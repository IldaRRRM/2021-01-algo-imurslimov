package ru.otus.algo.basestruct.queue;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class PriorityQueueImpl<T> implements PriorityQueue<T> {

    private final int defaultCapacity;
    private ItemList<T>[] itemLists;

    public PriorityQueueImpl(int defaultCapacity) {
        this.defaultCapacity = defaultCapacity;
        this.itemLists = new ItemList[defaultCapacity];
        for (int i = 0; i < defaultCapacity; i++) {
            itemLists[i] = new ItemList<>();
        }
    }

    @Override
    public void enqueue(int priority, T item) {
        if (priority > itemLists.length) {
            log.error("Недопустимый приритет = {}, максимум = {}", priority, defaultCapacity);
        } else {
            this.itemLists[priority - 1].add(item);
        }
    }

    @Override
    public T dequeue() {
        for (ItemList<T> itemList : itemLists) {
            if (itemList != null && itemList.getSize() > 0) {
                return itemList.pull();
            }
        }
        return null;
    }
}
