package zh.learn.java.ch23sorting.exercises;

import java.util.Comparator;

public class GenericQuickSort {
    public static <E extends Comparable<E>> void sort(E[] list) {
        sort(list, Comparator.naturalOrder());
    }

    public static <E> void sort(E[] list, Comparator<? super E> comparator) {
        sort(list, 0, list.length - 1, comparator);
    }

    private static <E> void sort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex = partition(list, first, last, comparator);
            sort(list, first, pivotIndex - 1, comparator);
            sort(list, pivotIndex + 1, last, comparator);
        }
    }

    private static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && comparator.compare(list[low], pivot) <= 0)
                ++low;
            while (low <= high && comparator.compare(list[high], pivot) > 0)
                --high;

            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && comparator.compare(list[high], pivot) >= 0)
            --high;

        if (comparator.compare(pivot, list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else
            return first;
    }
}
