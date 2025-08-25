import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Легендарный искатель приключений Дино обнаружил древнюю карту сокровищ, на которой отмечен архипелаг из n островов. На каждом острове спрятан клад определённой ценности, но острова соединены между собой опасными подводными туннелями, кишащими морскими чудовищами.
 * <p>
 * Дино начинает своё путешествие с острова номер 1 и хочет собрать как можно больше сокровищ. Однако из-за проклятья древних пиратов каждый остров можно посетить только один раз. После посещения острова туннель, ведущий к нему, магически запечатывается навсегда.
 * <p>
 * Дино может завершить своё путешествие на любом острове — ему не обязательно возвращаться на начальный остров.
 * <p>
 * Помогите Дино найти максимальную суммарную ценность сокровищ, которую он сможет собрать!
 * <p>
 * Формат ввода
 * Первая строка содержит два целых числа n и m (1 ≤ n ≤ 20, 0 ≤ m ≤ n(n-1)/2) — количество островов и количество туннелей соответственно.
 * <p>
 * Вторая строка содержит n целых чисел v₁, v₂, ..., vₙ (1 ≤ vᵢ ≤ 10⁶) — ценность сокровищ на каждом острове.
 * <p>
 * Следующие m строк содержат по два целых числа a и b (1 ≤ a, b ≤ n, a ≠ b), означающих, что между островами a и b существует туннель (туннели двунаправленные).
 * <p>
 * Формат вывода
 * Выведите одно целое число — максимальную суммарную ценность сокровищ, которую может собрать Дино.
 * <p>
 * Пример 1
 * Ввод
 * Вывод
 * 4 4
 * 10 30 20 5
 * 1 2
 * 2 3
 * 3 4
 * 1 4
 * 65
 * Пример 2
 * Ввод
 * Вывод
 * 5 3
 * 100 50 75 25 60
 * 1 2
 * 2 3
 * 4 5
 * 225
 * Пример 3
 * Ввод
 * Вывод
 * 3 0
 * 40 30 20
 * 40
 * Пример 4
 * Ввод
 * Вывод
 * 6 7
 * 15 25 35 45 55 65
 * 1 2
 * 2 3
 * 3 4
 * 4 5
 * 5 6
 * 1 6
 * 2 5
 * 240
 * Примечания
 * В первом примере граф островов образует цикл: 1-2-3-4-1. Дино может пройти маршрут 1 → 2 → 3 → 4, собрав сокровища ценностью 10 + 30 + 20 + 5 = 65. Это максимально возможная сумма, так как он посетил все острова.
 * <p>
 * Во втором примере граф состоит из двух отдельных компонент: острова {1,2,3} и острова {4,5}. Дино начинает с острова 1 и может дойти только до островов 2 и 3. Оптимальный путь: 1 → 2 → 3, собрав 100 + 50 + 75 = 225. Острова 4 и 5 недоступны из-за отсутствия соединения.
 * <p>
 * В третьем примере туннелей нет, поэтому Дино может посетить только остров 1, получив 40 золотых монет.
 * <p>
 * В четвёртом примере Дино может посетить все острова различными способами. Один из оптимальных маршрутов: 1 → 6 → 5 → 2 → 3 → 4, собрав 15 + 65 + 55 + 25 + 35 + 45 = 240.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int countOfIsland = Integer.parseInt(line.split(" ")[0]);
        int countOfTunele = Integer.parseInt(line.split(" ")[1]);

        String lineOFC = scanner.nextLine();
        final String[] islnadsMapOfCounts = lineOFC.split(" ");
        List<Island> islands = new ArrayList<>(islnadsMapOfCounts.length);
        for (int i = 0; i < islnadsMapOfCounts.length; i++) {
            islands.add(new Island(i, false, Integer.parseInt(islnadsMapOfCounts[i])));
        }

        List<Tunel> tunels = new ArrayList<>(countOfTunele);
        for (int i = 0; i < countOfTunele; i++) {
            final String nextLineTunel = scanner.nextLine();
            final String[] nextLineTunelMass = nextLineTunel.split(" ");
            final Island islandFrom = islands.get(Integer.parseInt(nextLineTunelMass[0]));
            final Island islandTo = islands.get(Integer.parseInt(nextLineTunelMass[1]));
            tunels.add(new Tunel(false, islandFrom, islandTo));
        }

        int result = 0;
        Island island = null;
        Tunel tunel = null;
        int currentNumberIfIsland = 0;
//        do {
//            island = islands.get(currentNumberIfIsland);
//            if (!island.isVisit()) {
//                result += island.getCount();
//            }
//            tunels.stream()
//                    .filter(tunel1 -> tunel1.getFromIsland().getNumberOfIsland() == island.getNumberOfIsland())
//                    .findFirst().get()
//        } while ()
    }
}

class Island {
    private int numberOfIsland;
    private boolean isVisit;
    private int count;

    public Island(int numberOfIsland, boolean isVisit, int count) {
        this.numberOfIsland = numberOfIsland;
        this.isVisit = isVisit;
        this.count = count;
    }

    public int getNumberOfIsland() {
        return numberOfIsland;
    }

    public boolean isVisit() {
        return isVisit;
    }

    public int getCount() {
        return count;
    }
}

class Tunel {
    private boolean isVisit;
    private Island fromIsland;
    private Island toIsland;

    public Tunel(boolean isVisit, Island fromIsland, Island toIsland) {
        this.isVisit = isVisit;
        this.fromIsland = fromIsland;
        this.toIsland = toIsland;
    }

    public boolean isVisit() {
        return isVisit;
    }

    public Island getFromIsland() {
        return fromIsland;
    }

    public Island getToIsland() {
        return toIsland;
    }


}
