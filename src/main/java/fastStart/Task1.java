package fastStart;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 1. Юля, Никита и задачи
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(Arrays.stream(line.split(" ")).map(Long::parseLong).reduce(Long::sum).get());
    }

}
