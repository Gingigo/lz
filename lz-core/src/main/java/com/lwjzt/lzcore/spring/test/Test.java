package com.lwjzt.lzcore.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Leexiaobu
 * @date 2020-09-12 19:37:33
 */
public class Test {
    public static void main(String[] args) {
        //Spring容器初始化流程
        /*
        * 1.执行AnnotationConfigApplicationContext的构造方法
        * 2.先执行父类的构造方法
        *  （1） ac对象
        *   (2)
        *
        * */
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(App.class);

//        System.out.println(ac.getBean(Y.class));
        System.out.println(ac.getBean(X.class));
    }
}
