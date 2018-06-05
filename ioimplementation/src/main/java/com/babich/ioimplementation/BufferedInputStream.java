package com.babich.ioimplementation;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {
    private static final int INITIAL_BUFFER_SIZE = 5;

    private byte[] buffer = new byte[INITIAL_BUFFER_SIZE];
    private InputStream inputStream;
    private int index;
    private int count;

    public BufferedInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        if (index == count) {
            count = inputStream.read(buffer);
            index = 0;
        }
        if (count == -1) {
            return -1;
        }
        return buffer[index++];
    }

    public int read(byte[] array, int off, int len) throws IOException {
        if (index == count) {
            count = inputStream.read(buffer);
            index = 0;
        }
        int unreadedCount = count - index;

        if (count == -1) {
            return -1;

        }
        if (len <= unreadedCount) {
            System.arraycopy(array, 0, array, off, unreadedCount);
            index += len;
            return len;
        } else {
            System.arraycopy(buffer, 0, array, off, unreadedCount);
        }
        count = inputStream.read(buffer);
        index = 0;
        return unreadedCount;
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }
}
