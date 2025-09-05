package fastStart;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String nextLine = scanner.nextLine();

        long a = Long.parseLong(nextLine.split(" ")[0]);
        long b = Long.parseLong(nextLine.split(" ")[1]);

        final long nod = nod(a, b);
        final long nok = (a * b) / nod;
        System.out.println(nod + " " + nok);
    }

    public static long nod(long a, long b) {
        long firstNumber = 0;
        long secondNumber = 0;

        if (a > b) {
            firstNumber = a;
            secondNumber = b;
        } else {
            firstNumber = b;
            secondNumber = a;
        }
        long temp = 0;
        do {
            temp = firstNumber % secondNumber;
            if (temp != 0) {
                firstNumber = secondNumber;
                secondNumber = temp;
            }
        } while (temp != 0);
        return secondNumber;
    }
}
