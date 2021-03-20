package ru.otus.algo.basestruct.queue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemNode<T> {

    private ItemNode<T> nextItemNode;
    private T value;

    public ItemNode(T value) {
        this.value = value;
    }
}
