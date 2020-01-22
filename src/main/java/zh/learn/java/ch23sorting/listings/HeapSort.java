package zh.learn.java.ch23sorting.listings;

import zh.learn.java.ch23sorting.exercises.Heap;

public class HeapSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        Heap<E> heap = new HeapWithComparable<>();

        for (int i = 0; i < list.length; ++i)
            heap.add(list[i]);

        for (int i = list.length - 1; i >= 0; --i)
            list[i] = heap.remove();
    }

    public static void main(String[] args) {
        Integer[] list = { 2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        sort(list);
        for (int i = 0; i < list.length; ++i)
            System.out.print(list[i] + " ");
    }
}
