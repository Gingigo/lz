package com.lwjzt.lzcore.mq.amqb.rabbitmq.java1;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Leexiaobu
 * @date 2020-10-29 9:25:24
 */
public class Consumer {


    public static void main(String[] args) throws IOException, TimeoutException {
    consume();
    }

    static void consume() throws IOException, TimeoutException {
        Connection con = Utils.getCon();
        Channel channel = con.createChannel();
        channel.queueDeclare("hello", true, false, false, null);
        /*queue
         * autoAck 自动确认
         *
         * */
        channel.basicConsume("hello", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consume msg"+new String(body));
            }
        });
//        channel.close();
//        con.close();
    }
}
