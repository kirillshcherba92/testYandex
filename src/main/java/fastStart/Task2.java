package fastStart;

import java.util.Scanner;

/**
 * 2. Треугольник
 */
public class Task2 {
    public static void main(String[] args) {
        String result = "NO";
        Scanner scanner = new Scanner(System.in);
        Tr tr = new Tr();
        tr.setSideA(scanner.nextInt());
        tr.setSideB(scanner.nextInt());
        tr.setSideC(scanner.nextInt());

        final boolean sideC = tr.getSideA() + tr.getSideB() > tr.getSideC();
        final boolean sideA = tr.getSideB() + tr.getSideC() > tr.getSideA();
        final boolean sideB = tr.getSideA() + tr.getSideC() > tr.getSideB();
        if (sideC && sideA && sideB) {
            result = "YES";
        }
        System.out.println(result);
    }
}

class Tr {
    private int sideA;
    private int sideB;
    private int sideC;

    public Tr() {
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }
}
