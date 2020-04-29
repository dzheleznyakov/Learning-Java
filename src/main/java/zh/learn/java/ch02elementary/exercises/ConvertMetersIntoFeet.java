package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class ConvertMetersIntoFeet {
    public static void main(String[] args) {
        final double FEET_PER_METER = 3.2786;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value for meter: ");
        double meters = input.nextDouble();

        double feet = meters * FEET_PER_METER;
        System.out.println(meters + " meters is " + feet + " feet");
    }
}
