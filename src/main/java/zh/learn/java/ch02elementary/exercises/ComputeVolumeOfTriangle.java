// chapter 02 exercise 2.2

package zh.learn.java.ch02elementary.exercises;

import java.util.Scanner;

public class ComputeVolumeOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of the sides and height of the Equilateral triangle: ");
        double length = input.nextDouble();

        double area = Math.sqrt(3) / 4 * length * length;
        double volume = area * length;

        System.out.println("The area is " + area);
        System.out.println("The volume of the Triangular prism is " + volume);
    }
}
