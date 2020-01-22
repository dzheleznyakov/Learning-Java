package zh.learn.java.ch23sorting.exercises;

import java.util.Comparator;

public class ImprovedQuickSort {
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
        E pivot = getPivot(list, first, last, comparator);
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

    private static <E> E getPivot(E[] list, int f, int l, Comparator<? super E> comparator) {
        E first = list[f];
        E last = list[l];
        E middle = list[(l - f) / 2];

        if (comparator.compare(middle, first) >= 0 && comparator.compare(middle, last) <= 0) {
            swap(list, f, (l - f) / 2);
            return middle;
        }
        if (comparator.compare(last, first) >= 0 && comparator.compare(last, middle) <= 0) {
            swap(list, f, l);
            return last;
        }
        return first;
    }

    private static <E> void swap(E[] list, int i1, int i2) {
        E temp = list[i1];
        list[i1] = list[i2];
        list[i2] = temp;
    }
}
