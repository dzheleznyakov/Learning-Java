package zh.learn.java.ch23sorting.exercises;

import java.util.Comparator;

public class GenericQuickSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        sort(list, Comparator.naturalOrder());
    }

    public static <E> void sort(E[] list, Comparator<? super E> comparator) {

    }
}
