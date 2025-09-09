package fastStart;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final Integer nextLine = scanner.nextInt();

        String[] strings = new String[nextLine * 2];
        for (int i = 0; i < nextLine * 2; i++) {
            final String line = scanner.next();
            strings[i] = line;
        }

        final String word = scanner.next();

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(word)) {
                if (i%2==0) {
                    System.out.println(strings[i+1]);
                } else {
                    System.out.println(strings[i-1]);
                }

                break;
            }
        }
    }
}
