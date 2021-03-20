package ru.otus.algo.basestruct.queue;

public interface PriorityQueue<T> {

    void enqueue(int priority, T item);

    T dequeue();

}
