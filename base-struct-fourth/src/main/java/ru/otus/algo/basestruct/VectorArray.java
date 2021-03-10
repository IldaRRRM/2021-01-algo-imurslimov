package ru.otus.algo.basestruct;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

public class VectorArray<T> extends DynamicArray<T> {

    private static final int DEFAULT_VECTOR_VALUE = 10;

    @Getter
    @Setter
    private int vector;

    public VectorArray(int vector) {
        this.array = new Object[vector];
        this.vector = vector;
    }

    public VectorArray() {
        this(DEFAULT_VECTOR_VALUE);
    }

    public VectorArray(Class<T> tClass, T[] receivedArray) {
        this.array = (T[]) Array.newInstance(tClass, receivedArray.length);
        System.arraycopy(receivedArray, 0, this.array, 0, receivedArray.length);
        this.vector = DEFAULT_VECTOR_VALUE;
        this.size = size();
    }


    @Override
    void resize() {
        Object[] resizeArray = new Object[this.array.length + this.vector];
        System.arraycopy(this.array, 0, resizeArray, 0, this.array.length);
        this.array = resizeArray;
    }
}
