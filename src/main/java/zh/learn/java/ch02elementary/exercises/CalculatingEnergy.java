// section 02 exercise 10
package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class CalculatingEnergy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount of water in kilograms: ");
        double waterKilos = input.nextDouble();

        System.out.print("Enter the initial temperature: ");
        double temperatureInit = input.nextDouble();

        System.out.print("Enter the final temperature: ");
        double temperatureFinal = input.nextDouble();

        double energy = waterKilos * (temperatureFinal - temperatureInit) * 4184;
        System.out.println("The energy needed is " + energy);
    }
}
