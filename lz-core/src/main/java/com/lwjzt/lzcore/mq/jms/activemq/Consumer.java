package com.lwjzt.lzcore.mq.jms.activemq;
import com.lwjzt.lzcore.domain.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer {
    @JmsListener(destination = "test.queue1")
    public void receiveMsg(String text) {
        System.out.println("            <<<<<<============ 收到消息： " + text);
    }
    @JmsListener(destination = "test.queue1")
    public void receiveMsg2(String text) {
        System.out.println("            <<<<<<============2222 收到消息： " + text);
    }
}