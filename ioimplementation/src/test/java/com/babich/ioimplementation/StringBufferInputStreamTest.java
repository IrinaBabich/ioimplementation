package com.babich.ioimplementation;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.StringBufferInputStream;

public class StringBufferInputStreamTest {
    private String string = "Hello";
    @Test
    public void testRead() throws IOException {
        StringBufferInputStream inputStream = new StringBufferInputStream(string);
        Assert.assertEquals('H', (char) inputStream.read());
        Assert.assertEquals('e', (char) inputStream.read());
        Assert.assertEquals('l', (char) inputStream.read());
        Assert.assertEquals('l', (char) inputStream.read());
        Assert.assertEquals('o', (char) inputStream.read());
    }
}
