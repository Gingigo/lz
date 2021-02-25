package com.lwjzt.lzcore.mq.amqb.rabbitmq.java3;

import com.lwjzt.lzcore.mq.amqb.rabbitmq.java1.Utils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

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
        /*指定交换机名称和类型*/
        channel.exchangeDeclare("logs","fanout");
            /*不需要了*/
//        channel.queueDeclare("work", true, false, false, null);
        String msg = "hello world";
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("logs", "", null, (msg + i).getBytes());
        }
        Utils.closeConAndChannel(con, channel);
    }
}
