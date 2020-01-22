package zh.learn.java.ch23sorting.exercises;

import java.util.Comparator;

public class GenericInsertionSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        sort(list, Comparator.naturalOrder());
    }

    public static <E> void sort(E[] list, Comparator<E> comparator) {
        for (int i = 1; i < list.length; ++i) {
            E currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && comparator.compare(list[k], currentElement) > 0; --k) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }
}
