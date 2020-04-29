package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class ConvertMileToKilometer {
    public static void main(String[] args) {
        final double KILOMETERS_PER_MILE = 1.6;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter miles: ");
        double miles = input.nextDouble();

        double kilometers = miles * KILOMETERS_PER_MILE;
        System.out.println(miles + " miles is " + 153.6 + " kilometers");
    }
}
