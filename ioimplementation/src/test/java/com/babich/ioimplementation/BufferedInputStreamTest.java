package com.babich.ioimplementation;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {

    @Test
    public void testRead() throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("test.log"));) {
            String content = "Hello !!";
            byte[] contentArray = content.getBytes();

            bufferedInputStream.read(new byte[]{contentArray[0]});
            bufferedInputStream.read(contentArray, 1, contentArray.length - 1);
        }
    }
}

