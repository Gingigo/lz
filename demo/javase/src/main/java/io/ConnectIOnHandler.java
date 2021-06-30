package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Leexiaobu
 * @date 2020-10-19 10:02:55
 */
public class ConnectIOnHandler extends Thread {
    static int x=100;
    public static void main(String[] args) throws Exception {

    }

    static void testBIO() throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(100);//线程池
        ServerSocket serverSocket = new ServerSocket(8088);
        while (!Thread.currentThread().isInterrupted()) {//主线程死循环等待新连接到来
            Socket socket = serverSocket.accept();
            executor.submit(new ConnectIOnHandler(socket));//为新的连接创建新的线程
        }
    }

    private Socket socket;

    public ConnectIOnHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {//死循环处理读写事件
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String something = bufferedReader.readLine();//读取数据
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                if (something != null) {
                    System.out.println(something);
                }
                writer.write("服务端已接受！");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
