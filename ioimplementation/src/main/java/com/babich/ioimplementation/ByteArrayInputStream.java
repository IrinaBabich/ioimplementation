package com.babich.ioimplementation;

import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStream extends InputStream {
    private byte[] array;
    private int index;

    public ByteArrayInputStream(byte[] buffer) {
        if (buffer == null) {
            throw new NullPointerException("Buffer couldn't be null");
        }
        this.array = buffer;
    }

    @Override
    public int read() throws IOException {
        if (index == array.length) {
            return -1;
        } else {
            return array[index++];
        }
    }

    private int unreadedCount = array.length - index;
    @Override
    public int read(byte[] buffer) throws IOException {

        if (array.length == index) {
            return -1;

            // если хватает места и буфер больше,
            // чем количество не вычитаных элементов, тогда вычитываем все
        } else if (buffer.length >= unreadedCount) {
            System.arraycopy(array, index, buffer, 0, unreadedCount);
            index += unreadedCount;
            return unreadedCount;
        } else {
            System.arraycopy(array, index, buffer, 0, unreadedCount);
            index += buffer.length;
            return buffer.length;
        }
    }

    @Override
    public int read(byte[] buffer, int off, int len) throws IOException {
        if (array.length == index) {
            return -1;

            // если длина массива больше, чем количество не вычитаных элементов
        } else if (len >= unreadedCount) {
            System.arraycopy(array, index, buffer, off, unreadedCount);
            index += unreadedCount;
            return unreadedCount;

            // если в буфере недостаточно места
        } else {
            System.arraycopy(array, index, buffer, off, len);
            index += len;
            return len;
        }
    }
}