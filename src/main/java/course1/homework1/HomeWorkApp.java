package course1.homework1;

/**
 * Домашнее задание №1 курс Java 1
 * @author Miroshnichenko Igor
 * @version 1.1
 * created on 2021-12-24
 */
public class HomeWorkApp {

    public static void main(String[] args) {
        System.out.println("Вывод трех слов в столбец:");
        printThreeWords();
        System.out.println("Проверка суммы двух чисел:");
        checkSumSign();
        System.out.println("Вывод цвета на экран:");
        printColor();
        System.out.println("Сравнение двух чисел:");
        compareNumbers();
    }

    /**
     * выводит три слова в столбец
     */
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /**
     * проверяет сумму двух чисел
     */
    public static void checkSumSign() {
        int a = 13;
        int b = 42;
        int summ = a + b;
        if (summ >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    /**
     * выводит цвет
     */
    public static void printColor() {
        int value = 1986;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    /**
     * сравнивает два числа
     */
    public static void compareNumbers() {
        int a = 666;
        int b = 777;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}
