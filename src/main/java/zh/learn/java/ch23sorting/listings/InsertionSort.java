package zh.learn.java.ch23sorting.listings;

public class InsertionSort {
    public static void sort(int[] list) {
        for (int i = 1; i < list.length; ++i) {
            int currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && list[k] > currentElement; --k) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
        }
    }

    public static void main(String[] args) {
        int[] list = { 2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        sort(list);
        for (int i = 0; i < list.length; ++i)
            System.out.print(list[i] + " ");
    }
}
