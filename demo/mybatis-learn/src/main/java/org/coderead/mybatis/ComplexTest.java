package org.coderead.mybatis;

import javassist.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.bean.Blog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author tommy
 * @title: ComplexTest
 * @projectName coderead-mybatis
 * @description: 复杂查询
 * @date 2020/6/16:21 PM
 */
public class ComplexTest {

    private SqlSession sqlSession;

    @Before
    public void init() throws SQLException {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(StatementHandlerTest.class.getResourceAsStream("/mybatis-config.xml"));
        sqlSession = factory.openSession();
    }

    @After
    public void over() {
        sqlSession.close();
    }

    // 懒加载测试
    @Test
    public void lazyTest() throws IllegalAccessException, NoSuchFieldException, InterruptedException {
        List<Blog> list = sqlSession.selectList("selectBlogById", 1);
        Blog blog=list.get(0);

        blog.getBody();
        Field comments = Blog.class.getDeclaredField("comments");
        comments.setAccessible(true);
        System.out.println("评论："+comments.get(blog));
    }


    @Test
    public void joinTest() throws IllegalAccessException, NoSuchFieldException, InterruptedException {
        List<Object> list = sqlSession.selectList("selectBlogById", 1);
        Blog blog= (Blog) list.get(0);
        System.out.println("返回行数"+blog.getComments());
    }



}
