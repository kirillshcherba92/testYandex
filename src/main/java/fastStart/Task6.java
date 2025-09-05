package fastStart;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 6. OpenCalculator
 */
public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String numbers = scanner.nextLine();
        final String resultCount = scanner.nextLine();

        long countOfNumberForAdd = 0;
        final Set<String> numbersSet = Arrays.stream(numbers.split(" ")).collect(Collectors.toSet());
        final Set<String> resultCountSet = Arrays.stream(resultCount.split("")).collect(Collectors.toSet());

        countOfNumberForAdd = resultCountSet.stream()
                .filter(s -> !numbersSet.contains(s))
                .count();
        System.out.println(countOfNumberForAdd);
    }
}
