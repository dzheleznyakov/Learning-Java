// chapter 02 exercise 2.13

package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class CompoundValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the monthly saving amount: ");
        double monthlyAmount = input.nextDouble();

        final double ANNUAL_INTEREST_RATE = 0.0375;
        double monthlyInterestRate = ANNUAL_INTEREST_RATE / 12;
        double monthlyCoeff = 1 + monthlyInterestRate;

        double firstMonthValue = monthlyAmount * monthlyCoeff;
        double secondMonthValue = (firstMonthValue + monthlyAmount) * monthlyCoeff;
        double thirdMonthValue = (secondMonthValue + monthlyAmount) * monthlyCoeff;
        double fourthMonthValue = (thirdMonthValue + monthlyAmount) * monthlyCoeff;
        double fifthMonthValue = (fourthMonthValue + monthlyAmount) * monthlyCoeff;
        double sixthMonthValue = (fifthMonthValue + monthlyAmount) * monthlyCoeff;

        System.out.println("After the first month, the account value is " + firstMonthValue);
        System.out.println("After the second month, the account value is " + secondMonthValue);
        System.out.println("After the third month, the account value is " + thirdMonthValue);
        System.out.println("After the sixth month, the account value is " + sixthMonthValue);
    }
}
