package zh.learn.java.ch23sorting.exercises;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertArrayEquals;

public class GenericBubbleSortTest {
    @Test
    public void testComparable() {
        String[] strings = {"aba", "aAb", "abc", "Abc", "aab"};

        GenericBubbleSort.sort(strings);

        String[] expected = {"Abc", "aAb", "aab", "aba", "abc"};
        assertArrayEquals(expected, strings);
    }

    @Test
    public void testComparator_Numbers() {
        Number[] list = { 2, 3, 2.5, 2, 5.77, 6, 1, 5.78, -2, 3, 14, 12, 0};

        GenericBubbleSort.sort(list, Comparator.comparingDouble(Number::doubleValue));

        Number[] expected = {-2, 0, 1, 2, 2, 2.5, 3, 3, 5.77, 5.78, 6, 12, 14};
        assertArrayEquals(expected, list);
    }
}
