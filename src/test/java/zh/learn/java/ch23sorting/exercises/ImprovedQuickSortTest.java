package zh.learn.java.ch23sorting.exercises;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ImprovedQuickSortTest extends AbstractSortTest {

    @Override
    protected <E extends Comparable<E>> Consumer<E[]> getComparableSort() {
        return ImprovedQuickSort::sort;
    }

    @Override
    protected <E> BiConsumer<E[], Comparator<? super E>> getComparatorSort() {
        return ImprovedQuickSort::sort;
    }
}
