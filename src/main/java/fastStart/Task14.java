package fastStart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine();


        final List<String> collect = Arrays.stream(line.split(" "))
                .collect(Collectors.toList());
        if (collect.size() == 3) {
            System.out.println(String.join(" ", collect));
            return;
        }

        List<Long> negativeNumber = new ArrayList<>();
        List<Long> positiveNumber = new ArrayList<>();
        List<String> resultNumberStr = new ArrayList<>();
        collect.stream()
                .map(Long::parseLong)
                .sorted()
                .forEach(s -> {
                    if (s < 0) {
                        negativeNumber.add(s);
                    } else {
                        positiveNumber.add(s);
                    }
                });
        final int indexPos = positiveNumber.size();
        if (negativeNumber.isEmpty()) {
            resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos - 1)));
            resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos - 2)));
            resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos - 3)));
            System.out.println(String.join(" ", resultNumberStr));
            return;
        }
        final int indexNeg = negativeNumber.size();
        if (positiveNumber.isEmpty()) {
            resultNumberStr.add(String.valueOf(negativeNumber.get(indexNeg - 1)));
            resultNumberStr.add(String.valueOf(negativeNumber.get(indexNeg - 2)));
            resultNumberStr.add(String.valueOf(negativeNumber.get(indexNeg - 3)));
            System.out.println(String.join(" ", resultNumberStr));
            return;
        }

        long negNymberPr = 0;
        long posNymberPr = 0;
        if (negativeNumber.size() >= 2) {
            negNymberPr = negativeNumber.get(0) * negativeNumber.get(1);
            if (positiveNumber.size() <= 2) {
                resultNumberStr.add(String.valueOf(negativeNumber.get(0)));
                resultNumberStr.add(String.valueOf(negativeNumber.get(1)));
                resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos-1)));
                System.out.println(String.join(" ", resultNumberStr));
                return;
            }
        }

        if (positiveNumber.size() >= 3) {
            posNymberPr = positiveNumber.get(indexPos-1) * positiveNumber.get(indexPos-2) * positiveNumber.get(indexPos-3);
            if (negNymberPr * positiveNumber.get(indexPos-1) < posNymberPr) {
                resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos-1)));
                resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos-2)));
                resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos-3)));
                System.out.println(String.join(" ", resultNumberStr));
                return;
            } else {
                resultNumberStr.add(String.valueOf(negativeNumber.get(0)));
                resultNumberStr.add(String.valueOf(negativeNumber.get(1)));
                resultNumberStr.add(String.valueOf(positiveNumber.get(indexPos-1)));
                System.out.println(String.join(" ", resultNumberStr));
                return;
            }
        }
    }
}
