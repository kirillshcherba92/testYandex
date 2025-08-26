package fastStart;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 3. Больше своих соседей
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine();
        int count = 0;

        final int[] numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::valueOf).toArray();
        for (int i = 1; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i-1] && numbers[i] > numbers[i+1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
