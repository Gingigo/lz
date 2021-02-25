package cn.lwjzt.designpattern.structural.adapter;

import java.io.*;

/**
 * @author Leexiaobu
 * @date 2020-09-07 22:01:34
 */
public class Adapter {

    public static void main(String[] args) {
        File file;
        try {
            FileInputStream fileInputStream = new FileInputStream("test.txt");
//            这一块就是Adapter
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
