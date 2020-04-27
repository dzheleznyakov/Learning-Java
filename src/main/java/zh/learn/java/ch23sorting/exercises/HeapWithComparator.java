package zh.learn.java.ch23sorting.exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapWithComparator<E> extends Heap<E> {
    private Comparator<? super E> comparator;
    private List<E> list = new ArrayList<>();

    public HeapWithComparator(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public HeapWithComparator(E[] objects) {
        for (int i = 0; i < objects.length; ++i)
            add(objects[i]);
    }

    @Override
    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if (comparator.compare(current, parent) > 0) {
                E temp = current;
                list.set(currentIndex, parent);
                list.set(parentIndex, temp);
            } else
                break;

            currentIndex = parentIndex;
        }
    }

    @Override
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) break;
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break;
        }

        return removedObject;
    }

    @Override
    public List<E> getItems() {
        return list;
    }

    @Override
    public int getSize() {
        return list.size();
    }
}
