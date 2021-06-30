package io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {


    public static void main(String[] args) throws IOException {
      new BioServer().startServer();
    }
    void startServer() throws IOException {
        startServer(8000);
    }

    void startServer(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("启动服务器" + serverSocket.getLocalSocketAddress());
        System.out.println("监听端口" + serverSocket.getLocalPort());

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = bufferedReader.readLine();
            if(s!=null){
                System.out.println(s);
                if(s.startsWith("end")){
                    System.out.println("socket关闭");
                    socket.close();
                    break;
                }
            }

        }
    }
}
