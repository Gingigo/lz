package com.lwjzt.lzcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoreApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(CoreApplication.class, args);
        SpringBeanUtil.setApplicationContext(applicationContext);
    }


    public static class SpringBeanUtil{
        private static ApplicationContext applicationContext;

        public static ApplicationContext getApplicationContext(){
            return applicationContext;
        }

        public static void setApplicationContext(ApplicationContext applicationContext){
            SpringBeanUtil.applicationContext = applicationContext;
        }

        public static <T> T getBean(String name){
            return (T)applicationContext.getBean(name);
        }

        public static <T> T getBean(Class<T> clazz){
            return applicationContext.getBean(clazz);
        }
    }

}
