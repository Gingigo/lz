package org.coderead.mybatis.resultMap;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.Mock;
import org.coderead.mybatis.StatementHandlerTest;
import org.coderead.mybatis.UserMapper;
import org.coderead.mybatis.bean.Blog;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @author tommy
 * @title: ResultMapTest
 * @projectName coderead-mybatis
 * @description: TODO
 * @date 2020/6/114:55 PM
 */
public class ResultMapTest {
    private SqlSession sqlSession;
    private UserMapper mapper;
    private Configuration configuration;

    @Before
    public void init() throws SQLException {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = factoryBuilder.build(StatementHandlerTest.class.getResourceAsStream("/mybatis-config.xml"));
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
         configuration = factory.getConfiguration();
    }
    @Test
    public void test(){
        MetaObject metaObject = configuration.newMetaObject(Mock.newBlog());
        metaObject.getValue("comments[1].user.name");
        MetaObject blog = configuration.newMetaObject(new Blog());
        blog.setValue("comments[0].id",1);
    }

    public static class TEst{
        String name;

        public TEst(String name) {
            this.name = name;
        }
    }

}
