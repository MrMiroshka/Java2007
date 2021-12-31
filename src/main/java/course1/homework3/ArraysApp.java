package course1.homework3;

/**
 * Домашнее задание №3 курс Java 1
 *
 * @author Miroshnichenko Igor
 * @version 1.3
 * created on 2021-12-31
 */
public class ArraysApp {

    /**
     * Печатает одномерный массив целых чисел в строку
     *
     * @param array целочисленный массив
     */
    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /**
     * Печатает двумерный массив целых чисел
     *
     * @param arrays целочисленный двумерный массив
     */
    public static void printArrays(int[][] arrays) {
        for (int[] array : arrays) {
            for (int number : array) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Печатает одномерный массив чисел типа byte в строку
     *
     * @param array массив чисел с типом byte
     */
    public static void printArray(byte[] array) {
        for (byte number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        //Задание 1
        byte[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Создали и инициализировали массив:");
        printArray(array);
        changeArray(array);
        System.out.println("Заменили 1 на 0 и 0 на 1 в ранее созданном массиве:");
        printArray(array);
        System.out.println();

        //Задание 2
        int[] arrayIntegers = new int[100];
        for (int i = 0; i < arrayIntegers.length; i++) {
            arrayIntegers[i] = i + 1;
        }
        System.out.println("Создали целочисленный одномерный массив и проинициалиизировали его:");
        printArray(arrayIntegers);
        System.out.println();

        //Задание 3
        int[] arrayIntegers2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Создали и инициализировали массив:");
        printArray(arrayIntegers2);
        for (int i = 0; i < arrayIntegers2.length; i++) {
            if (arrayIntegers2[i] < 6) {
                arrayIntegers2[i] *= 2;
            }
        }
        System.out.println("Значение в массиве < 6 умножили на 2:");
        printArray(arrayIntegers2);
        System.out.println();

        //Задание 4
        //размер матрицы
        int count = (int) (Math.random() * 9 + 4);
        int[][] doubleArray = new int[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                if (i == j) {
                    doubleArray[i][j] = 1;
                } else if (j == (count - 1 - i)) {
                    doubleArray[i][j] = 1;
                }
            }
        }
        System.out.println("Заполнили диагонали целочисленной двумерной матрицы единицами:");
        printArrays(doubleArray);
        System.out.println();

        //Задание 5
        int len = (int) (Math.random() * 9 + 4);
        int initialValue = (int) (Math.random() * 30 - 15);
        System.out.printf("Создаем и инициализируем массив длинной = %d и значениями = %d \n", len, initialValue);
        int[] newArray = creatArray(len, initialValue);
        printArray(newArray);
        System.out.println();

        //Задание 6
        //сделал допущение в задании - массив типа int
        // (разницы не вижу в данном случае вещественные числа хранит массив или целые)
        int[] arrayInteger3 = creatArrayR((int) (Math.random() * 19 + 4));
        int max = arrayInteger3[0];
        int min = arrayInteger3[0];
        for (int number : arrayInteger3) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        System.out.println("Создан и проинициализировван одномерный массив случайными целыми числами:");
        printArray(arrayInteger3);
        System.out.printf("В данном одномерном массиве минимальное число = %d, а максимальное число = %d \n", min, max);
        System.out.println();

        //Задание 7
        int[] arrayInteger4 = creatArrayR((int) (Math.random() * 19 + 4));
        //int[] arrayInteger4 = {2, 2, 2, 1, 2, 2, 10, 1};
        //int[] arrayInteger4 = {12, 1, 2, 1, 2, 2, 2, 2};
        printArray(arrayInteger4);
        System.out.printf("Есть ли в массиве место, в котором сумма левой и правой части массива равны - %b \n", checkBalance(arrayInteger4));
        System.out.println();

        //Задание 8
        int[] arrayInteger5 = creatArrayR((int) (Math.random() * 19 + 4));
        int n = (int) (Math.random() * 40 - 20);
        System.out.println("Создаем и инициализируем одномерный массив:");
        //int[] arrayInteger5 = {1, 2, 3, 4, 5, 6, 7, 8}; n=3;
        printArray(arrayInteger5);
        System.out.printf("Смещаем элементы данного массива на n = %d раз: \n", n);
        printArray(arrayOffset(arrayInteger5, n));
        System.out.println("Конец ДЗ)");
    }

    /**
     * Метод меняет в массиве значение 1 на 0 и 0 на 1.
     *
     * @param array массив чисел с тимоп byte
     */
    public static void changeArray(byte[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    /**
     * Метод создает целочисленный одномерный массив со значением по умолчанию
     *
     * @param len          длинна массива
     * @param initialValue значение массива по умолчанию
     * @return
     */
    public static int[] creatArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    /**
     * Метод создает одномерный массив со случайными значениями типа int
     *
     * @param len
     * @return
     */
    public static int[] creatArrayR(int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = (int) (Math.random() * 90 - 45);
            ;
        }
        return array;
    }

    /**
     * Метод  проверяет, есть ли в массиве место, в котором сумма левой и правой части массива равны
     *
     * @param array одномерный целочисленный массив
     * @return возвращает true/false
     */
    public static boolean checkBalance(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int leftSumm = 0;
            int rightSumm = 0;
            for (int j = 0; j < array.length - i - 1; j++) {
                leftSumm += array[j];
            }
            for (int j = array.length - 1; j > array.length - i - 2; j--) {
                rightSumm += array[j];
            }
            if (leftSumm != rightSumm) {
                continue;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод смещает все элементы массива на n позиций
     *
     * @param array массив
     * @param n     шаг смещения
     * @return возвращает измененный массив
     */
    public static int[] arrayOffset(int[] array, int n) {
        //вместо Math.abs() можно было сделать  if (n<0){count = n*(-1);}
        int count = Math.abs(n);
        for (int j = 0; j < count; j++) {
            if (n < 0) {
                int x = array[0];
                for (int i = 0; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = x;
            } else {
                int x = array[array.length - 1];
                for (int i = array.length - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = x;
            }
        }
        return array;
    }
}
