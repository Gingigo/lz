package com.lwjzt.lzcore.mq.jms.activemq;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;
import javax.jms.JMSDestinationDefinition;

@Service
public class Subscriber {
    @JmsListener(destination = "test.topic1", containerFactory = "myJmsContainerFactory")
    public void subscriber(String text) {
        System.out.println("===========<<<<<<<<收到订阅的消息" + text);
    }

    @JmsListener(destination = "test.topic1", containerFactory = "myJmsContainerFactory")
    public void subscriber2(String text) {
        System.out.println("===========<<<<<<<<22222收到订阅的消息" + text);
    }
    @Bean("myJmsContainerFactory")
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
