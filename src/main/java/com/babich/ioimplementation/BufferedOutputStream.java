package com.babich.ioimplementation;

import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStream extends OutputStream {
    private static int INITIAL_BUFFER_SIZE = 5;

    private OutputStream outputStream;
    private byte[] buffer;
    private int index;

    public BufferedOutputStream(OutputStream outputStream) {
        this(outputStream, INITIAL_BUFFER_SIZE);
    }

    public BufferedOutputStream(OutputStream outputStream, int bufferSize) {
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("Incorrect buffer size: " + bufferSize);
        }
        this.outputStream = outputStream;
        this.buffer = new byte[bufferSize];
    }

    @Override
    public void write(int value) throws IOException {
        buffer[index++] = (byte) value;
        if (index == buffer.length) {
            flush();
        }
    }

    public void write(byte[] array) throws IOException {
        write(array, 0, array.length);
    }

    public void write(byte[] array, int off, int len) throws IOException {
        // свободное место внутри Output Stream
        int emptySpace = array.length - index;

        // если свободного места меньше, чем количество элементов array length,
        // сбрасываем буфер, который у нас есть,
        // потом в тот же Output Stream закидываем array

        if (emptySpace <= len) {
            flush();
            outputStream.write(buffer, 0, index); // flush, то что пришло
        } else {
            System.arraycopy(array, off, buffer, index, len);
            index += len;
        }
    }

    @Override
    public void flush() throws IOException {
        outputStream.write(buffer, 0, index); // flush, того что есть сейчас в буфере
        index = 0;
    }

    @Override
    public void close() throws IOException {
        flush();
        outputStream.close();
    }
}