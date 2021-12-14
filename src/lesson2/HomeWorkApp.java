package lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {
        isBetween10and20(7, 8);
        isPositiveOrNegative(-10);
        isNegative(5);
        printWordNTimes("Hello!", 3);
        isLeapYear(1976);
    }

    public static boolean isBetween10and20(int a, int b) {
        int c;
        c = a + b;
        return c > 10 && c <= 20;
    }

    public static void isPositiveOrNegative(int number) {
        System.out.println(number >= 0 ? "Число положительное" : "Число отрицательное");
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printWordNTimes(String s, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                return true;
            }
            if (year % 100 == 0) {
                return false;
            }
            return true;
        } else {
            return false;
        }

    }

}
