// chapter 02 exercise 2.7

package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class FindNumberOfYears {
    public static void main(String[] args) {
        final int DAYS_PER_YEAR = 365;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of minutes: ");
        int minutes = input.nextInt();

        int days = minutes / 60 / 24;
        int years = days / DAYS_PER_YEAR;
        days %= DAYS_PER_YEAR;

        if (years == 0)
            System.out.println(minutes + " minutes is approximately " + days + " days");
        else if (days == 0)
            System.out.println(minutes + " minutes is approximately " + years + " years");
        else
            System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
    }
}
