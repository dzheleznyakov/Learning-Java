// chapter 02 exercise 2.17

 package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class WindChillTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
        double temperature = input.nextDouble();

        System.out.print("Enter the wind speed (>= 2) in miles per hour: ");
        double windSpeed = input.nextDouble();

        final double FREE_COEFF = 35.74;
        final double TEMP_COEFF = 0.6215;
        final double SPEED_COEFF = 35.75;
        final double SPEED_DEGREE = 0.16;
        final double TEMP_SPEED_COEFF = 0.4275;

        double windChillIndex = FREE_COEFF
                + TEMP_COEFF * temperature
                - SPEED_COEFF * Math.pow(windSpeed, SPEED_DEGREE)
                + TEMP_SPEED_COEFF * temperature * Math.pow(windSpeed, SPEED_DEGREE);

        System.out.println("The wind chill index is " + windChillIndex);
    }
}
