package zh.learn.java.ch23sorting.exercises;

public abstract class Heap<E> {
    public abstract void add(E newObject);

    public abstract E remove();

    public abstract int getSize();
}
