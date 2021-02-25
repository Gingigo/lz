package com.lwjzt.lzcore.mq.amqb.rabbitmq.java3;

import com.lwjzt.lzcore.mq.amqb.rabbitmq.java1.Utils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Leexiaobu
 * @date 2020-10-29 9:25:24
 */
public class Consumer1 {


    public static void main(String[] args) throws IOException, TimeoutException {
        consume();
    }

    static void consume() throws IOException, TimeoutException {
        Connection con = Utils.getCon();
        Channel channel = con.createChannel();
        //通道绑定交换机
        channel.exchangeDeclare("logs","fanout");
        //获取临时队列
        String queue = channel.queueDeclare().getQueue();
        //绑定交换机和队列
        channel.queueBind(queue,"logs","");
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consume1 msg : " + new String(body));
            }
        });
//        channel.close();
//        con.close();
    }
}
