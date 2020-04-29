package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class CalculateTips {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the subtotal and a gratuity rate: ");
        double subtotal = input.nextDouble();
        double gratuityRate = input.nextDouble() / 100;

        double gratuity = subtotal * gratuityRate;
        double total = subtotal + gratuity;
        System.out.println("The gratuity is $" + gratuity + " and total is $" + total);
    }
}
