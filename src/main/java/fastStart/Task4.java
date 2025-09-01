package fastStart;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4. Выставление тегов
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int line = scanner.nextInt();

        int[] resTegList = new int[line];
        for (int i = 0; i < line; i++) {
            if (i == 0 || i == 1) {
                resTegList[i] = 1;
            } else {
                resTegList[i] = resTegList[i -1] + resTegList[i -2];
            }
        }

        System.out.println(Arrays.stream(resTegList).reduce(Integer::sum).getAsInt());
    }
}
