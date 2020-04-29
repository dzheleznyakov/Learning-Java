package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class MultiplyDigitsInInteger {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        int num = input.nextInt();
        int n = num;
        if (n <= 0 || n >= 1000)
            throw new IllegalArgumentException(String.format("The number should be between 0 and 1000; found=[%d]", n));

        int product = 1;
        while (n > 0) {
            product *= (n % 10);
            n /= 10;
        }

        System.out.println("The multiplication of all digits in " + num + " is " + product);
    }
}
