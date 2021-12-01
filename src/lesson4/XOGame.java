package lesson4;

import java.util.Random;
import java.util.Scanner;

public class XOGame {
    static int SIZE;
    static int DOTS_TO_WIN;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();


        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Поздравляем! Вы выиграли!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил.");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        sc.close();
    }

    public static void initMap() {
        do{
            System.out.println("Введите размер поля и количество фишек для победы ");
            SIZE = sc.nextInt();
            DOTS_TO_WIN = sc.nextInt();
        } while(!(DOTS_TO_WIN <= SIZE));
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты метки: X,Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void aiTurn() {
        int x, y;
        // Сначала победить самому
        for (y = 0; y < SIZE; y++) {
            for (x = 0; x < SIZE; x++) {
                if (isCellValid(y, x)) {
                    map[y][x] = DOT_O;
                    if (checkWin(DOT_O)) {
                        return;
                    } else {
                        map[y][x] = DOT_EMPTY;
                    }
                }
            }
        }

        // Помешать игроку если он выиграет
        for (y = 0; y < SIZE; y++) {
            for (x = 0; x < SIZE; x++) {
                if (isCellValid(y, x)) {
                    map[y][x] = DOT_X;
                    if (checkWin(DOT_X)) {
                        map[y][x] = DOT_O;
                        return;
                    } else {
                        map[y][x] = DOT_EMPTY;
                    }
                }
            }
        }
        // Рандом, если победных комбинаций нет
        do {
            y = random.nextInt(SIZE);
            x = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWin(char c) {
        return checkHorizontals(c) || checkVerticals(c) || checkMainDiagonals(c) || checkSecondaryDiagonal(c);
    }


    public static boolean checkHorizontals(char c) { // Комбинация по горизонтали
        int countX;
        for (int i = 0; i < SIZE; i++) {
            countX = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c) {
                    countX++;
                } else {
                    countX = 0;
                }
                if (countX == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkVerticals(char c) { // Комбинация по горизонтали. Диагоналей может быть несколько
        int countY;
        for (int i = 0; i < SIZE; i++) {
            countY = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == c) {
                    countY++;
                } else {
                    countY = 0;
                }
                if (countY == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkMainDiagonals(char c) { // Комбинация по главной диагонали. Диагоналей может быть несколько
        int mainDiagonal;
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                mainDiagonal = 0;
                for (int t = 0; t < DOTS_TO_WIN; t++) {
                    if (map[i + t][j + t] == c) {
                        mainDiagonal++;
                    } else {
                        mainDiagonal = 0;
                    }
                    if (mainDiagonal == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean checkSecondaryDiagonal(char c) { // Комбинация по побочной диагонали
        int secondDiagonal;
        for (int i = 0; i <= SIZE - DOTS_TO_WIN; i++) {
            for (int j = 0; j <= SIZE - DOTS_TO_WIN; j++) {
                secondDiagonal = 0;
                for (int t = 0; t < DOTS_TO_WIN ; t++) {
                    if (map[SIZE - 1 - t - i][j + t] == c) {
                        secondDiagonal++;
                    } else {
                        secondDiagonal = 0;
                    }
                    if (secondDiagonal == DOTS_TO_WIN) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
