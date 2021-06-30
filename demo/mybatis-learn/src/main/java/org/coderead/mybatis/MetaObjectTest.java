package org.coderead.mybatis;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.BeanWrapper;
import org.apache.ibatis.session.Configuration;
import org.coderead.mybatis.bean.Blog;
import org.coderead.mybatis.bean.Comment;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author tommy
 * @title: MeataObjectTest
 * @projectName coderead-mybatis
 * @description: TODO
 * @date 2020/6/1310:11 AM
 */
public class MetaObjectTest {
    // 直接操作属性
    // 操作子属性
    // 自动创建属性对象
    // 自动查找属性名，支持下划线转驼峰
    // 基于索引访问数组

    @Test
    public void test(){
        // 装饰器模式
        Object blog=  Mock.newBlog();
        Configuration configuration=new Configuration();
        // 装饰
        MetaObject metaObject = configuration.newMetaObject(blog);
        metaObject.getValue("comments[0].user.name");
    }

    public static void main(String[] args) {
        // 装饰器模式
        Object blog=  Mock.newBlog();
        Configuration configuration=new Configuration();
        // 装饰
        MetaObject metaObject = configuration.newMetaObject(blog);
        metaObject.getValue("comments[0].user.name");
        BeanWrapper  beanWrapper=new BeanWrapper(metaObject,blog);

        beanWrapper.get(new PropertyTokenizer("comments[0]"));
        beanWrapper.get(new PropertyTokenizer("comments"));
    }
}
