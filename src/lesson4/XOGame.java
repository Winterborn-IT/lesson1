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
        System.out.println("Введите размер поля и фишек для победы ");
        SIZE = sc.nextInt();
        DOTS_TO_WIN = sc.nextInt();
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
            System.out.println("input X,Y");
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
        label:
        do {
            for (y = 0; y < SIZE; y++) {
                for (x = 0; x < SIZE; x++) {
                    // Возможна ли победа для компьютера
                    if (isCellValid(y, x)) {
                        map[y][x] = DOT_O;
                        if (checkWin(DOT_O)) {
                            break label;
                        } else {
                            map[y][x] = DOT_EMPTY;
                        }
                    // Помешать игроку если он выиграет
                        map[y][x] = DOT_X;
                        if (checkWin(DOT_X)) {
                            break label;
                        } else {
                            map[y][x] = DOT_EMPTY;
                        }
                    }
                }
            }
            y = random.nextInt(SIZE); // Рандом, если победных комбинаций нет
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

        for (int i = 0; i < SIZE; i++) {
            int countX = 0; // Комбинация по горизонтали
            int countY = 0; // Комбинация по вертикали
            int mainDiagonal = 0; // Комбинация по главной диагонали
            int secondaryDiagonal = 0; // Комбинация по второстепенной диагонали
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == c) {
                    countX++;
                } else {
                    countX = 0;
                }
                if (map[j][i] == c) {
                    countY++;
                } else {
                    countY = 0;
                }
                if (map[j][j] == c) {
                    mainDiagonal++;
                } else {
                    mainDiagonal = 0;
                }
                if (map[SIZE - j - 1][j] == c) {
                    secondaryDiagonal++;
                } else {
                    secondaryDiagonal = 0;
                }
                if (countX == DOTS_TO_WIN || countY == DOTS_TO_WIN || mainDiagonal == DOTS_TO_WIN || secondaryDiagonal == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

}
