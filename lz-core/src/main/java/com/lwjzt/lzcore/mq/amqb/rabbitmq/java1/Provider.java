package com.lwjzt.lzcore.mq.amqb.rabbitmq.java1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Leexiaobu
 * @date 2020-10-29 9:06:28
 */
public class Provider {
    public static void main(String[] args) throws IOException, TimeoutException {
        sendMessage();
    }

    public static void sendMessage() throws IOException, TimeoutException {
        /*设置连接*/
        Connection con = Utils.getCon();
        /*设置通道*/
        Channel channel = con.createChannel();
        /*
         通道绑定消息队列,如果没有则创建，如果有则需要保持一致
         * durable: 队列是否持续化
         * exclusive: 是否独占,被其他连接使用
         * autoDelete :消费完且连接关闭是否自动删除
         * map : 额外参数
         * */
        channel.queueDeclare("hello2", true, false, false, null);
        //发布消息
        // exchange 交换机名称,
        // routingKey 队列名称,
        // BasicProperties props 额外参数,
        // byte[] body 消息的具体内容
        String msg = "hello world";
        channel.basicPublish("", "hello", MessageProperties.PERSISTENT_BASIC, msg.getBytes());
        System.out.println("send : " + msg);
        Utils.closeConAndChannel(con,channel);
    }
}
