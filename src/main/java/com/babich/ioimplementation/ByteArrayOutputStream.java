package com.babich.ioimplementation;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutputStream extends OutputStream {
    private static final int INITIAL_SIZE = 5;
    private static final int GROW_SIZE = 10;
    private byte[] array;
    private int count;

    public ByteArrayOutputStream() {
        this(INITIAL_SIZE);
    }

    public ByteArrayOutputStream(int size){
        if(size <= 0){
            throw new IndexOutOfBoundsException("Size should be greater/not equals to 0 " + size);
        }
        this.array = new byte[size];
    }

    public void write(int value) throws IOException {
        if (array.length == count) {
            growSize(GROW_SIZE);
        }
        array[count++] = (byte) value;
    }

    private void growSize(int growSize) {
        byte[] newArray = new byte[array.length + growSize];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    @Override
    public void write(byte[] values) {
        write(values);
    }

    @Override
    public void write(byte[] values, int off, int len) {
        int unreadedCount = len - count;
        // если array length меньше, чем количество свободного места
        if (len <= unreadedCount) {
            System.arraycopy(values, off, array, count, len);
            count += len;
        }
        // если array.length > buffer.length, тогда увеличиваем size
        if (len > unreadedCount) {
            growSize(INITIAL_SIZE);
        }
        System.arraycopy(values, off, array, count, len);
        count += len;
    }
}


