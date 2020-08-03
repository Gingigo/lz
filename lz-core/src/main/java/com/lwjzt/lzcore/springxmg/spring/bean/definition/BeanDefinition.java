package com.lwjzt.lzcore.springxmg.spring.bean.definition;

import com.lwjzt.lzcore.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.prefs.AbstractPreferences;

/**
 * @author oujia
 */ //3.Import 导入
//@Import({BeanDefinition.Config.class})
@Configuration
public class BeanDefinition {
    public static void main(String[] args) {
        //1.创建容器
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext();
        //2.注册配置类
        acac.register(BeanDefinition.class);
        acac.refresh();
        User bean1 = (User)acac.getBean("user");
        User bean2 = (User)acac.getBean("user");
        System.out.println(bean1.hashCode());
        System.out.println(bean2.hashCode());
        System.out.println(bean1==bean2);
        acac.close();
    }
    //2 @Comment方式
//    @Component
    public static class Config {
//        1bean方式
        @Bean
//        @Lazy
        @Scope(scopeName = "prototype")
        public User user() {
            User user = new User();
            user.setUserName("超级无敌李小布");
            System.out.println("构造方法");
            ClassPathXmlApplicationContext;
            UrlResource
            return user;
        }


    }

}
