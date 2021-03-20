package ru.otus.algo.basestruct;

import lombok.Setter;

import java.lang.reflect.Array;

public class FactorArray<T> extends DynamicArray<T> {

    public static final int DEFAULT_FACTOR = 50;
    public static final int DEFAULT_INIT_LENGTH = 10;
    @Setter
    private int factor;

    public FactorArray() {
        this(DEFAULT_FACTOR, DEFAULT_INIT_LENGTH);
    }

    private FactorArray(int factor, int initLength) {
        this.factor = factor;
        array = new Object[initLength];
        size = 0;
    }

    public FactorArray(Class<T> tClass, T[] receivedArray, int factor) {
        this.array = (Object[]) Array.newInstance(tClass, receivedArray.length);
        System.arraycopy(receivedArray, 0, this.array, 0, this.array.length);
        this.size = size();
        this.factor = factor;
    }

    public FactorArray(Class<T> tClass, T[] receivedArray) {
        this(tClass, receivedArray, DEFAULT_FACTOR);
    }

    @Override
    void resize() {
        Object[] newArray = new Object[array.length + array.length * factor / 100];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
