package com.lwjzt.lzcore.mq.amqb.rabbitmq.java1;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Leexiaobu
 * @date 2020-10-29 9:41:31
 */
public class Utils {
    static Connection connection = null;
    static ConnectionFactory connectionFactory = null;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.31.192");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
    }

    public static Connection getCon() throws IOException, TimeoutException {
        if (connection != null) {
            return connection;
        }
        /*设置连接*/
        Connection connection = connectionFactory.newConnection();
        return connection;
    }

    public static void closeConAndChannel(Connection connection, Channel channel) {
        try {
            if (channel != null) {
                channel.close();
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
