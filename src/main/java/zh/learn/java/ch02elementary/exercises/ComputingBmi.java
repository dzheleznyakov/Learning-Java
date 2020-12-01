// section 02 exercise 14
package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class ComputingBmi {
    public static void main(String[] args) {
        final double KILOS_PER_POUND = 0.45359237;
        final double METERS_PER_INCH = 0.0254;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weightPounds = input.nextDouble();

        System.out.print("Enter height in inches: ");
        double heightInches = input.nextDouble();

        double weightKilos = weightPounds * KILOS_PER_POUND;
        double heightMeters = heightInches * METERS_PER_INCH;

        double bmi = weightKilos / heightMeters / heightMeters;

        System.out.println("BMI is " + bmi);
    }
}
