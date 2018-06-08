package com.babich.ioimplementation;

import java.io.IOException;
import java.io.InputStream;

public class StringBufferInputStream extends InputStream {

    private byte[] buffer;
    private int index;

    public StringBufferInputStream(String buffer) {
        this.buffer = buffer.getBytes();
    }

    @Override
    public int read() throws IOException {
        if (index < buffer.length) {
            return buffer[index++];
        } else {
            return -1;
        }
    }

    public int read(byte[] array) throws IOException {
        return read(array, 0, buffer.length);
    }

    @Override
    public int read(byte[] array, int off, int len) throws IOException {
        if (off < 0) {
            throw new IllegalArgumentException("off should be >=0, but was: " + off);
        }
        if (index >= buffer.length) {
            return -1;
        }

        System.arraycopy(buffer, index, array, off, len);
        index += len;
        return len;
    }
}
