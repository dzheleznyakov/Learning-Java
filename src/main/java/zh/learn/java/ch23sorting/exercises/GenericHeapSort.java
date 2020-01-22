package zh.learn.java.ch23sorting.exercises;

import zh.learn.java.ch23sorting.listings.HeapWithComparable;

import java.util.Comparator;

public class GenericHeapSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        sort(list, new HeapWithComparable<>());
    }

    public static <E> void sort(E[] list, Comparator<? super E> comparator) {
        sort(list, new HeapWithComparator<>(comparator));
    }

    private static <E> void sort(E[] list, Heap<E> heap) {
        for (int i = 0; i < list.length; ++i)
            heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; --i)
            list[i] = heap.remove();
    }
}
