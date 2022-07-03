// section 02 exercise 18

package zh.learn.java.ch02elementary.exercises;

public class PrintATable {
    public static void main(String[] args) {
        System.out.println("   a          b      Middle Point");

        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 1;
        double xm = ((int)(((x2 + x1) / 2.0) * 10)) / 10.0;
        double ym = ((int)(((y2 + y1) / 2.0) * 10)) / 10.0;
        System.out.println("(" + x1 + ", " + y1 +")     (" + x2 + ", " + y2 + ")     (" + xm + ", " + ym + ")");

        x1 = 1;
        y1 = 4;
        x2 = 4;
        y2 = 2;
        xm = ((int)(((x2 + x1) / 2.0) * 10)) / 10.0;
        ym = ((int)(((y2 + y1) / 2.0) * 10)) / 10.0;
        System.out.println("(" + x1 + ", " + y1 +")     (" + x2 + ", " + y2 + ")     (" + xm + ", " + ym + ")");

        x1 = 2;
        y1 = 7;
        x2 = 6;
        y2 = 3;
        xm = ((int)(((x2 + x1) / 2.0) * 10)) / 10.0;
        ym = ((int)(((y2 + y1) / 2.0) * 10)) / 10.0;
        System.out.println("(" + x1 + ", " + y1 +")     (" + x2 + ", " + y2 + ")     (" + xm + ", " + ym + ")");

        x1 = 3;
        y1 = 9;
        x2 = 10;
        y2 = 5;
        xm = ((int)(((x2 + x1) / 2.0) * 10)) / 10.0;
        ym = ((int)(((y2 + y1) / 2.0) * 10)) / 10.0;
        System.out.println("(" + x1 + ", " + y1 +")     (" + x2 + ", " + y2 + ")    (" + xm + ", " + ym + ")");

        x1 = 4;
        y1 = 11;
        x2 = 12;
        y2 = 7;
        xm = ((int)(((x2 + x1) / 2.0) * 10)) / 10.0;
        ym = ((int)(((y2 + y1) / 2.0) * 10)) / 10.0;
        System.out.println("(" + x1 + ", " + y1 +")    (" + x2 + ", " + y2 + ")    (" + xm + ", " + ym + ")");
    }
}
