package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class ConvertSquareMeterIntoPing {
    public static void main(String[] args) {
        final double PINGS_PER_METER = 0.3025;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number in square meters: ");
        double meters = input.nextDouble();

        double pings = meters * PINGS_PER_METER;
        System.out.println(meters + " square meters is " + pings + " pings");
    }
}
