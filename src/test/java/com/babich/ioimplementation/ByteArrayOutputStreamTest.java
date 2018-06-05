package com.babich.ioimplementation;

import org.junit.Test;

import java.io.IOException;

public class ByteArrayOutputStreamTest {
    @Test
    public void testWrite() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String string = "Hello world";
        for (int i = 0; i < string.length(); i++)
            outputStream.write(string.charAt(i));
        System.out.println(outputStream);
    }
}