package io;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class SocketClient {

    public static void main(String[] args) throws IOException {
      new SocketClient().startSocket(8080);
    }
    void startSocket(int port) throws IOException {
        System.out.println("启动客户端");
        Scanner scanner= new Scanner(System.in);
        while (scanner.hasNext()){
            /*这时还没连接，write时才连接*/
            Socket s = new Socket("127.0.0.1",port);
            OutputStream outputStream = s.getOutputStream();
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            String next = scanner.next();
            bufferedWriter.write(next);
            bufferedWriter.close();
            if(next.startsWith("end")){
                s.close();
                break;
            }
        }
    }
}
