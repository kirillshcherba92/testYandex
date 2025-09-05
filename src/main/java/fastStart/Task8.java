package fastStart;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            final String nextLine = scanner.nextLine();
        char lastDigitChar = 0;
        final String resYes = "YES";
        final String resNo = "NO";
        for (int i = 0; i < nextLine.length(); i++) {
            final char c = nextLine.charAt(i);
            if (Character.isDigit(c)) {
                if (lastDigitChar >= c) {
                    System.out.println(resNo);
                    return;
                }
                lastDigitChar = c;
            }
        }
        System.out.println(resYes);
    }
}
