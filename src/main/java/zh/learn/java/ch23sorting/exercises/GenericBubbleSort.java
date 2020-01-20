package zh.learn.java.ch23sorting.exercises;

import java.util.Comparator;

public class GenericBubbleSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        sort(list, Comparator.naturalOrder());
    }

    public static <E> void sort(E[] list, Comparator<? super E> comparator) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; ++k) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; ++i) {
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }
}
