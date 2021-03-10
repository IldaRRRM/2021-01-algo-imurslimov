package ru.otus.algo.basestruct.queue;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;

@Getter
public class ItemList<T> implements Iterable<T> {
    @Setter
    private ItemNode<T> root;
    @Setter
    private ItemNode<T> lastNode;
    private int size;

    public int size() {
        int size = 0;
        ItemNode<T> local = this.root;
        while (local != null) {
            local = local.getNextItemNode();
            size++;
        }
        return size;
    }

    public void add(T item) {
        if (this.root != null) {
            ItemNode<T> nextItemNode = new ItemNode<>(item);
            this.lastNode.setNextItemNode(nextItemNode);
            this.lastNode = nextItemNode;
        } else {
            this.root = new ItemNode<>(item);
            this.lastNode = root;
        }
        this.size++;
    }

    public T pull() {
        if (this.size > 0) {
            final T pulledValue = root.getValue();
            if (this.root.getNextItemNode() != null) {
                this.root = root.getNextItemNode();
            } else {
                this.root = null;
            }
            this.size--;
            return pulledValue;
        } else {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            ItemNode<T> currentItemNode = root;

            @Override
            public boolean hasNext() {
                return currentItemNode != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    final T currentValue = currentItemNode.getValue();
                    this.currentItemNode = currentItemNode.getNextItemNode();
                    return currentValue;
                } else {
                    return null;
                }
            }
        };
    }
}
