// chapter 02 exercise 2.8

package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class CurrentTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the time zone offset to GMT: ");
        int offset = input.nextInt();

        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        long currentSeconds = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;

        long currentHour = totalHours % 24 + offset;
        if (currentHour < 0) currentHour += 24;
        if (currentHour >= 24) currentHour -= 24;

        System.out.println("Current time is " + currentHour + ":" +
                currentMinute + ":" + currentSeconds + " GMT");
    }
}
