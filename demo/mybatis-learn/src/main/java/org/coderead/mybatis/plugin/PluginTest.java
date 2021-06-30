package org.coderead.mybatis.plugin;

import com.alibaba.druid.support.json.JSONUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.*;
import org.coderead.mybatis.StatementHandlerTest;
import org.coderead.mybatis.UserMapper;
import org.coderead.mybatis.bean.User;
import org.junit.Test;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

/**
 * @author tommy
 * @title: PluginTest
 * @projectName coderead-mybatis
 * @description: TODO
 * @date 2020/6/2110:55 AM
 */
public class PluginTest {

    private static Configuration configuration;
    private static final SqlSessionFactory factory;

    static {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        factory = factoryBuilder.build(StatementHandlerTest.class.getResourceAsStream("/mybatis-config.xml"));
        configuration = factory.getConfiguration();
        configuration.setLazyLoadTriggerMethods(new HashSet<>());
    }


    @Test
    public void pageTest() {
        UserMapper mapper = factory.openSession().getMapper(UserMapper.class);
        Page page = new Page(15, 3);
        List<User> list = mapper.findBuPage("男", page);
        mapper.findBuPage("男", page);
        mapper.findBuPage("男", page);
        mapper.setName(10,"鲁班");
        System.out.println("总数:" + page.getTotal());
        System.out.println("实际查询数量：" + list.size());
    }

    @Test
    public void pageTest2() {

        {
            SqlSession session = factory.openSession(ExecutorType.SIMPLE);
            UserMapper mapper = session.getMapper(UserMapper.class);
            Page page = new Page(15, 3);
            User user = new User();
            user.setSex("男");
            List<User> list = mapper.selectByUser(user, page);
            session.close();
        }

        {
            // 命中二级缓存
            SqlSession session = factory.openSession(ExecutorType.SIMPLE);
            UserMapper mapper = session.getMapper(UserMapper.class);
            Page page = new Page(15, 3);
            User user = new User();
            user.setSex("男");
            List<User> list = mapper.selectByUser(user, page);
            System.out.println("总行数：" + page.getTotal());
        }
    }

    @Test
    public void pluginWrapTest() {
        MyPlugin myPlugin = new MyPlugin() {
            @Override
            public String sayHello(String name) {
                System.out.println("hello" + name);
                return name + "hello";
            }
        };
        Interceptor ins;
        MyPlugin wrap = (MyPlugin) Plugin.wrap(myPlugin, new MyInterceptor());
        wrap.sayHello("ddd");
    }


    public interface MyPlugin {
        String sayHello(String name);
    }

    @Intercepts(@Signature(type = MyPlugin.class,
            method = "sayHello", args = {String.class}))
    public static class MyInterceptor implements Interceptor {

        @Override
        public Object intercept(Invocation invocation) throws Throwable {
            System.out.println("鲁班大叔");
            return invocation.proceed();
        }

        @Override
        public Object plugin(Object target) {
            return null;
        }

        @Override
        public void setProperties(Properties properties) {

        }
    }
}
