package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author Leexiaobu
 * @date 2020-11-21 11:48:15
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        Integer integer = new Integer(10);

        ArrayList<SocketChannel> list = new ArrayList<>();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8080));
        serverSocketChannel.configureBlocking(false);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            if (socketChannel == null) {
                try {
                    System.out.println(" sleep");
                    Thread.sleep(2000);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.print(" no connection");
            } else {
                System.out.println(" someone  con");
                /*NOTE 设置serverSocket 非阻塞*/
                serverSocketChannel.configureBlocking(false);
                list.add(socketChannel);
            }
            System.out.print( " size:"+list.size());
            for (SocketChannel channel : list) {
                int read = channel.read(byteBuffer);
                if (read > 0) {
                    byteBuffer.flip();
                    String s = Charset.forName("UTF-8").decode(byteBuffer).toString();
                    System.out.println(" recieve:"+s);
                }
            }
        }
    }
}
