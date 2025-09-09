package fastStart;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        final String line = scanner.nextLine();
        final List<Integer> collect = Arrays.stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        final int number = scanner.nextInt();

        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i : collect) {
            final int tempDiff = Math.abs(i - number);
            if (tempDiff == 0) {
                res = i;
                break;
            }
            if (tempDiff < diff) {
                diff = tempDiff;
                res = i;
            }
        }
        System.out.println(res);
    }
}
