package zh.learn.java.ch01inroduction.exercises;

public class AverageSpeedInKilometers {
    public static void main(String[] args) {
        System.out.println("A runner runs 24 miles in 1 hour, 40 minutes and 35 seconds");
        System.out.println("The average speed is " + (24 / (1 + 40.0 / 60.0 + 35 / (60.0 * 60.0)) * 1.6));
    }
}
