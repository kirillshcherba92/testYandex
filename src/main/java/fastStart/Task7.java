package fastStart;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 7. Количество слов в тексте
 */
public class Task7 {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            if (line.trim().isEmpty()) break;
            stringBuilder.append(line).append(" ");
        }

        final long count = Arrays.stream(stringBuilder.toString().split(" ")).map(String::trim).collect(Collectors.toSet()).size();
        System.out.println(count);

    }
}
