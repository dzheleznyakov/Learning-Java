package zh.learn.java.ch23sorting.exercises;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.junit.Assert.assertArrayEquals;

public abstract class AbstractSortTest {

    protected abstract <E extends Comparable<E>> Consumer<E[]> getComparableSort();

    protected abstract <E> BiConsumer<E[], Comparator<? super E>> getComparatorSort();

    @Test
    public void testComparable() {
        System.out.println("\n----- " + this.getClass().getSimpleName());
        System.out.println("Comparable Sort");

        String[] strings = {"aba", "aAb", "abc", "Abc", "aab"};

        long start = System.currentTimeMillis();
        LocalDateTime startTime = LocalDateTime.ofEpochSecond(start, 0, ZoneOffset.UTC);
        System.out.println("Start: " + startTime.toLocalTime());

        this.<String>getComparableSort()
                .accept(strings);

        long stop = System.currentTimeMillis();
        LocalDateTime stopTime = LocalDateTime.ofEpochSecond(stop, 0, ZoneOffset.UTC);
        System.out.println("Stop: " + stopTime.toLocalTime());
        System.out.println("Runtime: " + (stop - start) + " millis");

        String[] expected = {"Abc", "aAb", "aab", "aba", "abc"};
        assertArrayEquals(expected, strings);
    }

    @Test
    public void testComparator_Numbers() {
        System.out.println("\n----- " + this.getClass().getSimpleName());
        System.out.println("Comparator Sort");

        Number[] list = { 2, 3, 2.5, 2, 5.77, 6, 1, 5.78, -2, 3, 14, 12, 0};

        long start = System.currentTimeMillis();
        LocalDateTime startTime = LocalDateTime.ofEpochSecond(start, 0, ZoneOffset.UTC);
        System.out.println("Start: " + startTime.toLocalTime());

        this.<Number>getComparatorSort()
                .accept(list, Comparator.comparingDouble(Number::doubleValue));

        long stop = System.currentTimeMillis();
        LocalDateTime stopTime = LocalDateTime.ofEpochSecond(stop, 0, ZoneOffset.UTC);
        System.out.println("Stop: " + stopTime.toLocalTime());
        System.out.println("Runtime: " + (stop - start) + " millis");

        Number[] expected = {-2, 0, 1, 2, 2, 2.5, 3, 3, 5.77, 5.78, 6, 12, 14};
        assertArrayEquals(expected, list);
    }
}
