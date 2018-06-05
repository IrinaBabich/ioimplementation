package com.babich.ioimplementation;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class IOTest {

    public static void main(String[] args) throws IOException {
//        File file = new File("text.txt");
//        System.out.println(file.getAbsolutePath());

        InputStream inputStream = new FileInputStream("C:\\Users\\Sonechko-pc\\IdeaProjects\\List\\src\\test\\resources\\test.txt");
        InputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int value;

        while ((value = bufferedInputStream.read()) != -1) {
            System.out.print((char) value);
        }
    }
}
