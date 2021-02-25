package io;

import java.io.*;

/**
 * @author oujia
 */
public class Io {
    public static void main(String[] args) throws IOException {
        new Io().testFileReader();
//        new Io().testFileWriter();
        new Io().bufferedWriter();
//        new Io().inputStream();
//        new Io().fileBufferReader();
//        new Io().inputBufferStream();
//        new Io().fileReader();
    }

    /**
     * @description 字符流读取
     * @author Leexiaobu 2020/08/13 10:54:04
     * @version 1.0
     */
    void testFileReader() {
        File file = new File("javase/src/main/java/io/test.txt");
        try (FileReader fileReader = new FileReader(file);
        ) {
            int data = fileReader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //迭代一次 读入char 数组
        try (FileReader fileReader = new FileReader(file);
        ) {
            char[] chars = new char[5];
            int data;
            while ((data = fileReader.read(chars)) != -1) {
                /*注意这块要注意长度 */
                String s = new String(chars, 0, data);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 字符流写出
     * @author Leexiaobu 2020/08/13 11:10:11
     * @version 1.0
     */
    void testFileWriter() {
        File file = new File("javase/src/main/java/io/testOut.txt");
        try (FileWriter fileWriter = new FileWriter(file);) {
            String text = "leexiaobu out";
            char[] chars = text.toCharArray();
            fileWriter.write(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 字符包装流读取
     * @author Leexiaobu 2020/08/13 11:11:55
     * @version 1.0
     */
    void BufferedReader() {
        File file = new File("javase/src/main/java/io/test.txt");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file));
        ) {
            String s = fileReader.readLine();
            while (s != null) {
                System.out.println(s);
                s = fileReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description 包装字符流写出
     * @author Leexiaobu 2020/08/13 11:15:39
     * @version 1.0
     */
    void bufferedWriter() {
        File file = new File("javase/src/main/java/io/testOut.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
            bufferedWriter.write("leexiaobu");
            bufferedWriter.newLine();
            bufferedWriter.write("无敌");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void inputStream() {
        File file = new File("javase/src/main/java/io/test.txt");
        try (FileInputStream fileInputStream = new FileInputStream(file);
        ) {
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println((char) data);
                data = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void inputBufferStream() throws IOException {
        File file = new File("javase/src/main/java/io/test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int data = bufferedInputStream.read();
        while (data != -1) {
            System.out.println((char) data);
            data = bufferedInputStream.read();
        }
    }

    void fileReader() throws IOException {
        File file = new File("javase/src/main/java/io/test.txt");
        FileReader fileReader = new FileReader(file);
        int read = fileReader.read();
        while (read != -1) {
            System.out.println((char) read);
            read = fileReader.read();
        }

    }

}
