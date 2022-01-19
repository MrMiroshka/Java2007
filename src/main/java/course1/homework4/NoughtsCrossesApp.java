package course1.homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Домашнее задание №4 курс Java 1
 *
 * @author Miroshnichenko Igor
 * @version 1.4
 * created on 2022-01-16
 */
public class NoughtsCrossesApp {

    //игровое поле
    public static char[][] map;

    //считаем, что игровое поле всегда имеет форму квадрата (т.е. все стороны равны)
    public static final int SIZE = 5;

    //количество точек для победы
    public static final int DOTS_TO_WIN = 4;

    //Описание возможных точек на игровом поле
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    //Счетчики точек (сколько подряд одинаковых значений) в строках,столбцах и диагоналях
    public static int[] masDots;

    //массив который будет хранить координаты возможного хода по строкам,стобцам и диагоналям
    public static int[] tempMasAllXY;


    public static final Random RANDOM = new Random();

    //сканер
    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Проинициализирует игровое поле.
     */
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    /**
     * Вывод игрового поля на экран
     */
    public static void printMap() {
        //нумеруем верхний ряд
        for (int i = 0; i <= map.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        //пишем строки мапы
        for (int i = 0; i < map.length; i++) {
            //выводим номер строки
            System.out.print((i + 1) + " ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /**
     * Ход человека
     */
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    /**
     * Проверка валидны ли значения поля
     *
     * @param x координата х
     * @param y координата y
     * @return да/нет
     */
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y > SIZE) {
            return false;
        }
        if (map[y][x] != DOT_EMPTY) {
            return false;
        }
        return true;
    }

    /**
     * Подтверждает найдена ли позиция которуюнужно блокировать
     *
     * @param index 0-строки, 1-стобцы, 2-главная диагональ, 3-побочная диагональ
     */
    public static boolean isBlockWinPosition(int index) {
        if (masDots[index] == DOTS_TO_WIN - 2 || masDots[index] == DOTS_TO_WIN - 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Возвращает координаты на игровом поле, где нужно поставить значение для блокировки игрока
     * p.s. в реализации есть допущения, например алгоритм строит не все возможные выйгрышные комбинации человека, а первую подходящую к блокировке (проход мапы начинается с левого верхнего угла).
     *
     * @return возвращает массив с координатами на игровом поле, где нужно поставить значение или {'-1','-1'}
     */
    public static int[] isBlockingHumen() {
        int[] masXY = new int[2];
        masXY[0] = -1;
        masXY[1] = -1;

        //выделил массив в поле, дабы не плодить новые массивы каждый раз при вызове метода (а метод будет вызываться каждый раз при ходе компьютера)
        for (int i = 0; i < tempMasAllXY.length; i++) {
            tempMasAllXY[i] = -1;
        }

        for (int i = 0; i < 4; i++) {
            masDots[i] = 0;
        }

        for (int i = 0; i < SIZE; i++) {
            //после каждого прохода обнуляем значения по строкам и стобцам
            masDots[0] = 0;
            masDots[1] = 0;
            //обнуляем координаты возможного хода по строкам,стобцам
            for (int k = 0; k < 4; k++) {
                tempMasAllXY[k] = -1;
            }

            for (int j = 0; j < SIZE; j++) {
                //проверяем строки
                if (checkDotsToWin(map[i][j], DOT_X, 0) || isBlockWinPosition(0)) {
                    if (masDots[0] == 1 && i != 0 && j != 0 && isCellValid(j - 1, i)) {
                        tempMasAllXY[1] = j - 1;
                        tempMasAllXY[0] = i;
                    } else if (isBlockWinPosition(0)) {
                        if (tempMasAllXY[0] != -1) {
                            masXY[0] = tempMasAllXY[0];
                            masXY[1] = tempMasAllXY[1];
                            return masXY;
                        } else if (i != SIZE - 1 && j != SIZE - 1 && isCellValid(j + 1, i)) {
                            masXY[0] = i;
                            masXY[1] = j + 1;
                            return masXY;
                        }
                    }
                }

                //проверяем столбцы (благодаря допущению что игровое поле квадратное)
                if (checkDotsToWin(map[j][i], DOT_X, 1) || isBlockWinPosition(1)) {
                    if (masDots[1] == 1 && j != 0 && isCellValid(i, j - 1)) {
                        tempMasAllXY[2] = j - 1;
                        tempMasAllXY[3] = i;
                    } else if (isBlockWinPosition(1)) {
                        if (tempMasAllXY[2] != -1) {
                            masXY[0] = tempMasAllXY[2];
                            masXY[1] = tempMasAllXY[3];
                            return masXY;
                        } else if (i != SIZE - 1 && j != SIZE - 1 && isCellValid(i, j + 1)) {
                            masXY[0] = j + 1;
                            masXY[1] = i;
                            return masXY;
                        }

                    }
                }

                //проверяем диагонали
                if (i == j) {
                    if (checkDotsToWin(map[i][j], DOT_X, 2) || isBlockWinPosition(2)) {
                        if (masDots[2] == 1 && i != 0 && j != 0 && isCellValid(i - 1, j - 1)) {
                            tempMasAllXY[5] = i - 1;
                            tempMasAllXY[4] = j - 1;
                        } else if (isBlockWinPosition(2)) {
                            if (tempMasAllXY[4] != -1) {
                                masXY[0] = tempMasAllXY[5];
                                masXY[1] = tempMasAllXY[4];
                                return masXY;
                            } else if (i != SIZE - 1 && j != SIZE - 1 && isCellValid(i + 1, j + 1)) {
                                masXY[0] = i + 1;
                                masXY[1] = j + 1;
                                return masXY;
                            }

                        }
                    }
                }

                if (SIZE - j - 1 - i == 0) {
                    if (checkDotsToWin(map[i][j], DOT_X, 3) || isBlockWinPosition(3)) {
                        if (masDots[3] == 1 && i != 0 && j != SIZE - 1 && isCellValid(j + 1,i - 1 )) {
                            tempMasAllXY[7] = i - 1;
                            tempMasAllXY[6] = j + 1;
                        } else if (isBlockWinPosition(3)) {
                            if (tempMasAllXY[6] != -1) {
                                masXY[0] = tempMasAllXY[7];
                                masXY[1] = tempMasAllXY[6];
                                return masXY;
                            } else if (i != SIZE - 1 && j != 0 && isCellValid(j - 1,i + 1)) {
                                masXY[0] = i + 1;
                                masXY[1] = j - 1;
                                return masXY;
                            }

                        }
                    }
                }

            }
        }
        return masXY;
    }

    /**
     * Ход компьютера
     */
    public static void aiTurn() {
        int x, y;
        int[] masXY = isBlockingHumen();
        x = masXY[1];
        y = masXY[0];
        if (x == -1 || (x != -1 && !isCellValid(x, y))) {
            do {
                x = RANDOM.nextInt(SIZE);
                y = RANDOM.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
        System.out.println("Робот делает ход в " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    /**
     * Сравниевает значение текущей позиции на игровом поле с значением - symbol. Если есть совпадение
     * увеличиваем значение числа идущих подряд символов на игровом поле и возвращаем true, иначе обнуляем
     * счетчик и возвращаем false
     *
     * @param element значение текущей позиции на игровом поле
     * @param symbol  с этим символом идет сравнение
     *                masDots храним количество идущих подряд сиволов - symbol, в строке,стобце и диагоналях
     * @param index   указывает на то, где мы сейчас ведем поиск - строке (0),стобце(1),главная диагональ(2) или побочная(3)
     * @return возвращаем true если значение текущнй позии на игровом поле = искомому сиволу - symbol
     */
    public static boolean checkDotsToWin(char element, char symbol, int index) {
        if (element == symbol) {
            masDots[index]++;
            return true;
        } else {
            masDots[index] = 0;
        }
        return false;
    }

    /**
     * Проверка победы
     *
     * @param symbol Символ для которого проверяем. Крестик или Нолик
     * @return true, если выйграл
     */
    public static boolean checkWin(char symbol) {
        //Счетчики точек (сколько подряд одинаковых значений) в строках - 1 элемент массива,стобцах -2 элемент массива,
        // главной - 3 элемент массива и побочной диагоналей - 4 элемент массива
        //что бы каждый раз не создавался массив, выделил его в поле
        for (int i = 0; i < 4; i++) {
            masDots[i] = 0;
        }

        for (int i = 0; i < SIZE; i++) {
            //после каждого прохода обнуляем значения по строкам и стобцам
            masDots[0] = 0;
            masDots[1] = 0;

            for (int j = 0; j < SIZE; j++) {
                //проверяем строки
                if (checkDotsToWin(map[i][j], symbol, 0) && (masDots[0] == DOTS_TO_WIN)) {
                    return true;
                }

                //проверяем столбцы (благодаря допущению что игровое поле квадратное)
                if (checkDotsToWin(map[j][i], symbol, 1) && (masDots[1] == DOTS_TO_WIN)) {
                    return true;
                }

                //проверяем диагонали
                if (i == j) {
                    if (checkDotsToWin(map[i][j], symbol, 2) && (masDots[2] == DOTS_TO_WIN)) {
                        return true;
                    }
                } else if (SIZE - j - 1 - i == 0) {
                    if (checkDotsToWin(map[i][j], symbol, 3) && (masDots[3] == DOTS_TO_WIN)) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

    /**
     * Проверка что в поле не осталось ни одной свободной ячейки
     *
     * @return true, если нет ни одной свободной ячейки
     */
    public static boolean isMapFull() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Инициализирует игру
     * P.S.:в задании не было, но если нужно - (предварительно сделать поля не константами)
     * можно добавить произвольный рамер игрового поля (SIZE) и произвольное количество
     * выигрышных фишек (DOTS_TO_WIN) вводимый пользователем с консоли с соответствующими проверками (DOTS_TO_WIN <= SIZE).
     */
    public static void initGame() {
        //Создаем счетчики точек (сколько подряд одинаковых значений) в строках,столбцах и диагоналях
        masDots = new int[]{0, 0, 0, 0};
        //Создаем массив который будет хранить координаты возможного хода компьютера (для блокировки выйгрышного
        // хода пользователя) по строкам,стобцам и диагоналям
        tempMasAllXY = new int[8];

        initMap();
        printMap();
    }

    public static void main(String[] args) {

        initGame();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Побеждает человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Робот выиграл");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра завершена");


    }
}
