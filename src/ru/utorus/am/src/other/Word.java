package ru.utorus.am.src.other;

import java.util.Arrays;

public class Word {

    int size;
    int currentReadPosition;
    int currentWritePosition;
    int[] array = new int[1000];

    public Word() {
        size = 0;
        currentReadPosition = 0;
        currentWritePosition = 0;

    }

    public int getSize() {
        return size;
    }

    public void next() {
        int crp = currentReadPosition;
        if ((++crp) < size) {
            currentReadPosition++;
        }
    }

    public void preview() {
        int crp = currentReadPosition;
        if ((--crp) >= 0) {
            currentReadPosition--;
        }
    }

    public int read() {
        return array[currentReadPosition];
    }

    public void write(int _int) {
        if ((currentWritePosition) <= size) {
            array[currentWritePosition++] = _int;
            size++;
        }
    }

    public void flush() {
        while (getPosition() > 0) {
            preview();
        }
    }

    public int getPosition() {
        return currentReadPosition;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}

