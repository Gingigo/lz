package com.lwjzt.lzcore.springxmg.spring.bean.definition;

import com.lwjzt.lzcore.domain.Person;
import com.lwjzt.lzcore.domain.User;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.stereotype.Component;

@Configuration
public class ConditionalDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ano = new AnnotationConfigApplicationContext(ConditionTest.class);
        System.out.println(ano.getBean("leeCondition"));
        Object person = ano.getBean("person");
        System.out.println(person);
        ano.close();
    }

    public static class ConditionTest {
        @Bean(name = "leeCondition")
        public User user() {
            User user = new User();
            user.setUserName("李大布超级无敌");
            return user;
        }
        @Bean(name = "person")
        @Conditional(ConditionLee.class)
        public Person person    () {
            return new Person();
        }
    }

    public static class ConditionLee implements Condition {

        /**
         * Determine if the condition matches.
         *
         * @param context  the condition context
         * @param metadata the metadata of the {@link AnnotationMetadata class}
         *                 or {@link MethodMetadata method} being checked
         * @return {@code true} if the condition matches and the component can be registered,
         * or {@code false} to veto the annotated component's registration
         */
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            if (context.getBeanFactory().containsBean("leeCondition")) {
                System.out.println("包含 leeCondition");
                return true;
            }
            System.out.println("不 包含 leeCondition");
            return false;
        }
    }
}
