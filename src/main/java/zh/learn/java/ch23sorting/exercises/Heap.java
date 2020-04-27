package zh.learn.java.ch23sorting.exercises;

import java.util.List;

public abstract class Heap<E> {
    public abstract void add(E newObject);

    public abstract E remove();

    public abstract List<E> getItems();

    public abstract int getSize();
}
