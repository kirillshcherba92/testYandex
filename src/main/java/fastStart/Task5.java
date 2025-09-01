package fastStart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5. 29 задача аналитики
 */
public class Task5 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine();
        final double[] array = Arrays.stream(line.split(" ")).mapToDouble(Double::valueOf)
                .toArray();
        final double a = array[0];
        final double b = array[1];
        final double c = array[2];

        final double d = descriminant(a, b, c);
        if (d < 0) {
            System.out.println(0);
            return;
        }
        if (d == 0) {
            System.out.println(1);
            System.out.println(-b / (2 * a));
            return;
        }

        if (d > 0) {
            System.out.println(2);
            final double x1 = (-b + Math.sqrt(d)) / (2 * a);
            final double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x2 + " " + x1);
        }

    }

    public static double descriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }
}
