package lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println();

        checkSumSign(1, 2);
        System.out.println();

        printColor(200);
        System.out.println();

        compareNumbers(5 , 10);

    }

    public static void printThreeWords() {
        System.out.println("Orange\n" +
                "Banana\n" +
                "Apple");
    }

    public static void checkSumSign(int a, int b) {
        int c;
        c = a + b;
        if (c >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 || value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(int a, int b) {
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
