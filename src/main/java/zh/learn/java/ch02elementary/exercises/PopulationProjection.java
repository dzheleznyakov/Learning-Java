// section 02 exercise 11
package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class PopulationProjection {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of years: ");
        int numberOfYears = input.nextInt();

        int population = 312_032_486 + numberOfYears * (
                (int) (365 * 24 * 60 * 60.0 / 7.0)
                        - (int) (365 * 24 * 60 * 60.0 / 13.0)
                        + (int) (365 * 24 * 60 * 60.0 / 45.0));

        System.out.println("The population in " + numberOfYears + " years is " + population);
    }
}
