package org.coderead.mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.coderead.mybatis.bean.Blog;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author tommy
 * @title: LazyTest
 * @projectName coderead-mybatis
 * @description: TODO
 * @date 2020/6/1410:37 AM
 */
public class LazyTest {

    private static Configuration configuration;
    private static final SqlSessionFactory factory;

    static {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        factory = factoryBuilder.build(StatementHandlerTest.class.getResourceAsStream("/mybatis-config.xml"));
        configuration = factory.getConfiguration();
        configuration.setLazyLoadTriggerMethods(new HashSet<>());
    }

    /**
     * 除调用get方法外，toString、hashCode、equals、clone 均可以加载
     * 设置 aggressiveLazyLoading =true 所有方法均会触发懒加载
     */
    @Test
    public void lazyTest() {
        SqlSession sqlSession = factory.openSession();
        Blog blog = sqlSession.selectOne("selectBlogById", 1);
        blog.getComments();
        /*
            以下方法均会触发懒加载
            blog.toString();
            blog.hashCode();
            blog.equals(new Object());
        */
    }

    /**
     * 关闭会话后之懒加载依然可以运行
     */
    @Test
    public void stopSessionTest() {
        SqlSession sqlSession = factory.openSession();
        Blog blog = sqlSession.selectOne("selectBlogById", 1);
        sqlSession.close();
        blog.getComments();
    }

    /**
     * 调用设置方法 后懒加载器将会被移除
     */
    @Test
    public void lazySetTest() {
        SqlSession sqlSession = factory.openSession();
        Blog blog = sqlSession.selectOne("selectBlogById", 1);
        blog.setComments(new ArrayList<>());//0 移除懒加载属性
        System.out.println("评论数：" + blog.getComments().size());
    }



    // 序列化--》字节码   -》反序列化成对象


    /***
     *
     * 序列化之后依然可以进行
     * 注：需要设置configurationFactory 指定configuration构建器
     */
    @Test
    public void lazySerializableTest() throws IOException, ClassNotFoundException {
        SqlSession sqlSession = factory.openSession();
        Blog blog = sqlSession.selectOne("selectBlogById", 1);
        byte[] bytes = writeObject(blog);
        Blog blog2 = (Blog) readObject(bytes);
        System.out.println("--------反列化完成-------");
        blog2.getComments();
    }

    /**
     * 使用 arthas可查看动态代理的类
     * 第一步：搜索类 sc org.coderead.mybatis.bean.Blog
     * 第二步：反编译 jad org.coderead.mybatis.bean.Blog<动态生成>
     */
    public static void main(String[] args) throws Exception {
        new LazyTest().lazyTest();
        System.in.read();
    }

    public static class ConfigurationFactory {
            public static Configuration getConfiguration() {
            return configuration;
        }
    }

    //序列化测试
    @Test
    public void SerializableTest() throws IOException, ClassNotFoundException {
        Bean bean = new Bean("0000", "aaaa");
        byte[] bytes = writeObject(bean);
        Object blog = readObject(bytes);
        System.out.println(blog);
    }


    private static byte[] writeObject(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(out);
        outputStream.writeObject(obj);
        return out.toByteArray();
    }

    private static Object readObject(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream inputStream = new ObjectInputStream(in);
        return inputStream.readObject();
    }

    private static class Bean implements Serializable {
        public String id;
        public String name;

        //在序列化时 重写对象
        protected final Object writeReplace() throws ObjectStreamException {
            return new Bean("8888", "llll");
        }

        //在反序列化时 转换对象
        protected final Object readResolve() throws ObjectStreamException {
            System.out.println("readResolve");
            this.name = "鲁班大叔";
            return this;
        }

        public Bean(String id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
