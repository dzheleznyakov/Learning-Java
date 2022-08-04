// chapter 02 exercise 2.21

package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class CalculateFutureInvestmentValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Enter number of years: ");
        int numberOfYears = input.nextInt();

        double futureInvestmentValue =
                investmentAmount * Math.pow(1 + annualInterestRate / 12 / 100, numberOfYears * 12);
        futureInvestmentValue = ((int)(futureInvestmentValue * 100)) / 100.0;

        System.out.println("Future value is $" + futureInvestmentValue);
    }
}
