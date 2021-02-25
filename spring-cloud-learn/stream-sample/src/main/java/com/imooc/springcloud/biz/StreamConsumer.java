package com.imooc.springcloud.biz;

import com.imooc.springcloud.topic.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 半仙.
 */
@Slf4j
@EnableBinding(value = {
        Sink.class,
        MyTopic.class,
        GroupTopic.class
        , DelayedTopic.class
        , ErrorTopic.class,
        ReQueueTopic.class
        , DlqTopic.class,
        FallBackTopic.class
}
)
public class StreamConsumer {

    /**
     * 1。类上绑定@EnableBinding
     * 2.方法上@StreamListener
     */

    @StreamListener(Sink.INPUT)
    public void consume(Object payload) {
        log.info("message consumed successfully, payload={}", payload);
    }

    // 自定义消息广播
    @StreamListener(MyTopic.INPUT)
    public void consumeMyMessage(Object payload) {
        log.info("My message consumed successfully, payload={}", payload);
    }


    @StreamListener(GroupTopic.INPUT)
    public void consumeGroupMyMessage(Object payload) {
        log.info("Group message consumed successfully, payload={}", payload);
    }

    @StreamListener(DelayedTopic.INPUT)
    public void delayMyMessage(MessageBean payload) {
        log.info("delayed message consumed successfully, payload={}", payload.getPayload());
    }

    private AtomicInteger count = new AtomicInteger(1);

    @StreamListener(ErrorTopic.INPUT)
    public void errorMyMessage(MessageBean payload) {
        log.info("Are You Ok?");
        if (count.incrementAndGet() % 3 == 1) {
            log.info(" I am good ");
        } else {
            log.info("what's your problem");
            throw new RuntimeException("what's up?");
        }
        log.info("errorMyMessage message consumed successfully, payload={}", payload.getPayload());
    }


    @StreamListener(ReQueueTopic.INPUT)
    public void reQueueMessage(MessageBean payload) {
        log.info("Are You Ok?");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
//        throw new RuntimeException("what's up?");
    }
    @StreamListener(DlqTopic.INPUT)
    public void dlqTopic(MessageBean payload) {
        log.info("DLQ-Are You Ok?");
        if (count.incrementAndGet() % 3 == 1) {
            log.info("DLQ- I am good ");
        } else {
            log.info("DLQ-what's your problem");
            throw new RuntimeException("what's up?");
        }
        log.info("DLQ-dlqMessage message consumed successfully, payload={}", payload.getPayload());
    }

    // Fallback + 升级版本
    @StreamListener(FallBackTopic.INPUT)
    public void goodbyeBadGuy(MessageBean bean,
                              @Header("version") String version) {
        log.info("Fallback - Are you OK?");

        if ("1.0".equalsIgnoreCase(version)) {
            log.info("Fallback - Fine, thank you. And you?");

        } else if ("2.0".equalsIgnoreCase(version)) {
            log.info("unsupported version");
            throw new RuntimeException("I'm not OK");
        } else {
            log.info("Fallback - version={}", version);
        }
    }
    // 降级流程
    @ServiceActivator(inputChannel = "fallback-topic.fallback-group.errors")
    public void fallback(Message<?> message) {
        log.info("fallback entered");
    }
    
}
