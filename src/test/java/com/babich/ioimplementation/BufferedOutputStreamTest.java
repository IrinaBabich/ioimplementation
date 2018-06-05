package com.babich.ioimplementation;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamTest {
    @Test
    public void test() throws Exception{
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("test.log"));) {
            String content = "Hello !!";
            byte[] contentArray = content.getBytes();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(contentArray);

            bufferedOutputStream.write(inputStream.read());

            byte[] buffer = new byte[3];
            int count;
            while((count = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, count);
            }
        }
    }
}