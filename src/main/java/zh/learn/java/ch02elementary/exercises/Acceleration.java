// chapter 02 exercise 2.9

package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class Acceleration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter v0, v1 and t: ");
        double v0 = input.nextDouble();
        double v1 = input.nextDouble();
        double t = input.nextDouble();

        double avgAcc = (v1 - v0) / t;

        System.out.println("The average acceleration is " + avgAcc);
    }
}
