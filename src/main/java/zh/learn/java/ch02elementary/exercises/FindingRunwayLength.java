// chapter 02 exercise 2.12

package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class FindingRunwayLength {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter speed and acceleration: ");
        double speed = input.nextDouble();
        double acceleration = input.nextDouble();

        double length = speed * speed / 2 / acceleration;

        System.out.println("The minimum runway length for the airplane is " + length);
    }
}
