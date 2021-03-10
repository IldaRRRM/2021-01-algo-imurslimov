package ru.otus.algo.basestruct;

import lombok.Getter;

public abstract class DynamicArray<T> {

    @Getter
    protected Object[] array;

    protected int size;

    abstract void resize();

    protected int size() {
        int currentSize = 0;
        for (Object item : this.array) {
            if (item != null) {
                currentSize++;
            }
        }
        this.size = currentSize;
        return this.size;
    }

    protected void add(T item) {
        final int arrayLastIndexBeforeResize = this.array.length - 1;
        if (this.size >= arrayLastIndexBeforeResize) {
            resize();
        }
        this.array[this.size] = item;
        this.size++;
    }


    protected void add(T item, int index) {
        while (index >= this.array.length - 1 || this.size >= this.array.length - 1) {
            resize();
        }

        if (containsItem(index)) {
            insertToMiddle(item, index);
        } else {
            this.array[index] = item;
        }
        this.size++;
    }

    protected T remove(int index) {
        if (index > this.array.length - 1) {
            return null;
        } else if (index == this.array.length - 1 || index == this.size - 1) {
            return removeFromEnd(index);
        } else {
            return removeFromMiddle(index);
        }
    }

    protected boolean isEmpty() {
        for (Object item : this.array) {
            if (item != null) {
                return true;
            }
        }
        return false;
    }

    protected T getItem(int index) {
        if (!(index > this.array.length - 1)) {
            return (T) this.array[index];
        } else {
            return null;
        }
    }

    protected boolean containsItem(int index) {
        if (index >= array.length) {
            return false;
        } else {
            return this.array[index] != null;
        }
    }

    protected void insertToMiddle(T item, int index) {
        for (int i = index; i < this.array.length - 1; i++) {
            swap(index, i + 1);
        }
        this.array[index] = item;
    }

    protected void swap(int leftIndex, int rightIndex) {
        T temp = (T) this.array[leftIndex];
        this.array[leftIndex] = this.array[rightIndex];
        this.array[rightIndex] = temp;
    }

    protected void setArray(Object[] array) {
        this.array = array;
        this.size = size();
    }

    private T removeFromMiddle(int index) {
        T temp = (T) array[index];
        this.array[index] = null;
        for (int i = index; i < this.size - 1; i++) {
            swap(i, i + 1);
        }
        this.size--;
        return temp;
    }

    private T removeFromEnd(int index) {
        if (this.array[index] != null) {
            final T item = getItem(index);
            this.array[index] = null;
            this.size--;
            return item;
        } else {
            return null;
        }
    }
}
