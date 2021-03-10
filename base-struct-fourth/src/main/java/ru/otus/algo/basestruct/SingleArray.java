package ru.otus.algo.basestruct;

import java.lang.reflect.Array;

public class SingleArray<T> extends DynamicArray<T> {

    public SingleArray(Class<T> tClass) {
        this.array = (T[]) Array.newInstance(tClass, 0);
    }

    public SingleArray(Class<T> tClass, T[] receivedArray) {
        this.array = (T[]) Array.newInstance(tClass, receivedArray.length);
        System.arraycopy(receivedArray, 0, this.array, 0, receivedArray.length);
        this.size = size();
    }

    @Override
    public void resize() {
        final int currentArraySize = array.length;
        Object[] resizeArray = new Object[currentArraySize + 1];
        System.arraycopy(array, 0, resizeArray, 0, currentArraySize);
        this.array = resizeArray;
    }
}
