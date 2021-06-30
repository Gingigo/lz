package org.coderead.mybatis;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.*;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.bean.Blog;
import org.coderead.mybatis.bean.User;
import org.junit.Test;

import java.util.*;

/**
 * @author tommy
 * @title: BoundSql
 * @projectName coderead-mybatis
 * @description: 动态SQL
 * @date 2020/6/183:31 PM
 */
public class BoundSqlTest {

    private static Configuration configuration;
    private static final SqlSessionFactory factory;

    static {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        factory = factoryBuilder.build(StatementHandlerTest.class.getResourceAsStream("/mybatis-config.xml"));
        configuration = factory.getConfiguration();
        configuration.setLazyLoadTriggerMethods(new HashSet<>());
    }


    @Test
    public void ognlTest(){
        ExpressionEvaluator evaluator=new ExpressionEvaluator();
        Blog blog=Mock.newBlog();
        //MetaObject
        // 1.访问属性
        boolean b = evaluator.evaluateBoolean("id!=null&& author.name!=null", blog);
        System.out.println(b);
        // 2.调用方法
        boolean b1 = evaluator.evaluateBoolean("comments!=null&&comments.size()>0||comments.isEmpty", blog);
        System.out.println(b1);
        boolean b2 = evaluator.evaluateBoolean("comments!=null&&comments.get(0).body!=null", blog);

        boolean b3 = evaluator.evaluateBoolean("comments!=null&&comments[0].body!=null", blog);
        // 3
        System.out.println(b2+""+b3);
        // 遍历集合
        Iterable<?> comments = evaluator.evaluateIterable("comments", blog);
        for (Object comment : comments) {
            System.out.println(comment);
        }
        //
    }

    @Test
    public void ifTest(){
        User user = new User();
        user.setId(1);
        user.setName("鲁班大叔");
        DynamicContext context = new DynamicContext(configuration, user);
        //静态节点逻辑
        new StaticTextSqlNode("select * from users ").apply(context);
        // where

        IfSqlNode ifSqlNode=new IfSqlNode(new StaticTextSqlNode(" and id=#{id}") ,"id!=null");
        IfSqlNode ifSqlNode2=new IfSqlNode(new StaticTextSqlNode(" or name=#{name}") ,"name!=null");
        MixedSqlNode mixedSqlNode=new MixedSqlNode(Arrays.asList(ifSqlNode,ifSqlNode2));
        //添加Where逻辑
        WhereSqlNode where=new WhereSqlNode(configuration,mixedSqlNode);
        where.apply(context);
        // 1.添加 where 前缀
        // 2.移除指定关键字的前后缀

        //TrimSqlNode
        System.out.println(context.getSql());
    }

    @Test
    public void foreachTest(){
        HashMap<Object, Object> parameter = new HashMap<>();
        parameter.put("list",Arrays.asList(10,2,3,4,5));
        List<Object> list = factory.openSession().selectList("findByIds", parameter);
        System.out.println(list.size());
    }







}
