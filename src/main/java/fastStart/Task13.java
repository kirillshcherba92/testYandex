package fastStart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int i = scanner.nextInt();
        int[] ints = new int[i];
        for (int j = 0; j < i; j++) {
            ints[j] = scanner.nextInt();
        }

        List<Integer> res = new ArrayList<>();
        while (!isCorrect(ints)) {
            res.add(ints[0]);
            ints = pop(ints);
        }
        System.out.println(res.size());
        System.out.println(res.reversed().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    private static boolean isCorrect(int[] ints) {
        boolean isCorrect = true;
        for (int j = 0; j < ints.length; j++) {
            if (ints[j] != ints[ints.length - 1 - j]) {
                isCorrect = false;
                break;
            }
        }
        return isCorrect;
    }

    private static int[] pop(int[] ints) {
        int[] newInts = new int[ints.length - 1];
        for (int i = 0; i < newInts.length; i++) {
            newInts[i] = ints[i + 1];
        }
        return newInts;
    }
}
