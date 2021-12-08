package lesson3;

import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {
        // Задание №1
        int[] firstArr = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        invertElements(firstArr);
        // Задание №2
        int[] secondArr = new int[100];
        fillArray(secondArr);
        // Задание №3
        int[] thirdArray = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeArray(thirdArray);
        // Задание №4
        int[][] fourthArray = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        fillDiagonal(fourthArray);
        // Задание №5
        createArrayFromSize(8, 1);
        // Задание №6
        int[] testArray = new int[]{4, 1, 3, 9, 0, 1, 3, 7};
        findMin(testArray);
        findMax(testArray);
        // Задание №7
        arrSumBalance(createArray());
        // Задание №8
        int[] arr = new int[]{0, 1, 2, 3, 4, 5};
        cycleElements(arr, -2);

    }

    public static int[] createArray() {
        Random rand = new Random();
        int ArrLength = rand.nextInt(10);
        int[] arr = new int[ArrLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(20);
        }
        return arr;
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */

    public static void invertElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    /**
     * 2. Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     */

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
     * пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */

    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)и с помощью
     * цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
     * Определить элементы одной из диагоналей можно по следующему принципу:
     * индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
     */

    public static void fillDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
                if (i + j == array[i].length - 1) {
                    array[i][j] = 1;
                }
            }
        }
    }

    /**
     * 5. Написать метод, принимающий на вход два аргумента: len и initialValue,
     * и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
     */
    public static int[] createArrayFromSize(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    /**
     * 6. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
     */

    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= min) {
                min = array[i];
            }
        }
        return min;
    }

    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * 7. Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     */

    public static boolean arrSumBalance(int[] array) {
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < array.length; i++) {
            sumLeft += array[i];
            sumRight = 0;
            for (int j = 1 + i; j < array.length; j++) {
                sumRight += array[j];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    /**
     * 8. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
     * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */

    public static void cycleElements(int[] array, int a) {
        int num = 0;
        if (a > 0) {
            for (int i = 0; i < a; i++) {
                for (int j = array.length - 1; j > 0; j--) {
                    num = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = num;
                }
            }
        } else {
            for (int i = 0; i < -a; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    num = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = num;
                }
            }
        }
    }

}
