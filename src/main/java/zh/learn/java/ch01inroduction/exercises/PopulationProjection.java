// section 01 exercise 11
package zh.learn.java.ch01inroduction.exercises;

public class PopulationProjection {
    public static void main(String[] args) {
        System.out.println("Population:");
        System.out.println("This year : " + 312_032_486);
        System.out.println("In 1 year : " +
                (312_032_486 + (int)(365 * 24 * 60 * 60.0 / 7.0) - (int)(365 * 24 * 60 * 60.0 / 13.0) + (int)(365 * 24 * 60 * 60.0 / 45.0)));
        System.out.println("In 2 years: " +
                (312_032_486 + 2 * ((int)(365 * 24 * 60 * 60.0 / 7.0) - (int)(365 * 24 * 60 * 60.0 / 13.0) + (int)(365 * 24 * 60 * 60.0 / 45.0))));
        System.out.println("In 3 years: " +
                (312_032_486 + 3 * ((int)(365 * 24 * 60 * 60.0 / 7.0) - (int)(365 * 24 * 60 * 60.0 / 13.0) + (int)(365 * 24 * 60 * 60.0 / 45.0))));
        System.out.println("In 4 years: " +
                (312_032_486 + 4 * ((int)(365 * 24 * 60 * 60.0 / 7.0) - (int)(365 * 24 * 60 * 60.0 / 13.0) + (int)(365 * 24 * 60 * 60.0 / 45.0))));
        System.out.println("In 5 years: " +
                (312_032_486 + 5 * ((int)(365 * 24 * 60 * 60.0 / 7.0) - (int)(365 * 24 * 60 * 60.0 / 13.0) + (int)(365 * 24 * 60 * 60.0 / 45.0))));
    }
}
