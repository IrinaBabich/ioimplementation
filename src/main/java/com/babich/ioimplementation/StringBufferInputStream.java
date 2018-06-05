package com.babich.ioimplementation;

import java.io.IOException;
import java.io.InputStream;

public class StringBufferInputStream extends InputStream {

    private String buffer;
    private int index;
    private int count;

    public StringBufferInputStream(String string) {
        this.buffer = string;
        count = string.length();
    }

    @Override
    public int read() throws IOException {
        if (index < count) {
            return buffer.charAt(index++);
        } else {
            return -1;
        }
    }

    @Override
    public int read(byte[] array, int off, int len) throws IOException {
        if (buffer == null & index >= count) {
            return -1;
        }
        if (index + len > count) {
            len = count - index;
        }
        String string = buffer;
        int stringCount = len;
        while (--stringCount >= 0) {
            array[off++] = (byte) string.charAt(index++);
        }
        return len;
    }
}

