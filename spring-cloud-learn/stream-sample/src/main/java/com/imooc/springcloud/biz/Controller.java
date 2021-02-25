package com.imooc.springcloud.biz;

import com.imooc.springcloud.topic.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 半仙.
 */
@RestController
@Slf4j
public class Controller {

    @Autowired
    private MyTopic producer;

    @Autowired
    private GroupTopic groupTopic;

    @Autowired
    private DelayedTopic delayedTopic;


    @Autowired
    private ErrorTopic errorTopic;

    @Autowired
    ReQueueTopic reQueueTopic;
    @Autowired
    DlqTopic dlqTopic;

    // 简单广播消息
    @PostMapping("send")
    public void sendMessage(@RequestParam(value = "body") String body) {
        producer.output().send(MessageBuilder.withPayload(body).build());
    }

    @PostMapping("sendToGroup")
    public void sendToGroup(@RequestParam(value = "body") String body) {
        groupTopic.output().send(MessageBuilder.withPayload(body).build());
    }

    @PostMapping("sendToDM")
    public void sendToDM(@RequestParam(value = "body") String body, @RequestParam(value = "seconds") Integer seconds) {
        MessageBean messageBean = new MessageBean();
        messageBean.setPayload(body);
        log.info("ready to send DM");
        delayedTopic.output().send(
                MessageBuilder.withPayload(messageBean)
                        .setHeader("x-delay", 1000 * seconds)
                        .build()
        );
    }

    @PostMapping("sendErrorMS")
    public void sendErrorMS(@RequestParam(value = "body") String body) {
        MessageBean messageBean = new MessageBean();
        messageBean.setPayload(body);
        errorTopic.output().send(
                MessageBuilder.withPayload(messageBean)

                        .build()
        );
    }

    @PostMapping("requeue")
    public void requeue(@RequestParam(value = "body") String body) {
        MessageBean messageBean = new MessageBean();
        messageBean.setPayload(body);
        reQueueTopic.output().send(
                MessageBuilder.withPayload(messageBean)

                        .build()
        );
    }

    @PostMapping("dlq")
    public void sendToDLQ(@RequestParam(value = "body") String body) {
        MessageBean messageBean = new MessageBean();
        messageBean.setPayload(body);
        dlqTopic.output().send(
                MessageBuilder.withPayload(messageBean)

                        .build()
        );
    }
    @Autowired
    private FallBackTopic fallbackTopicProducer;
    // fallback + 升版
    @PostMapping("fallback")
    public void sendMessageToFallback(
            @RequestParam(value = "body") String body,
            @RequestParam(value = "version", defaultValue = "1.0") String version) {
        MessageBean msg = new MessageBean();
        msg.setPayload(body);
        fallbackTopicProducer.output().send(
                MessageBuilder.withPayload(msg)
                        .setHeader("version", version)
                        .build());
    }
}
