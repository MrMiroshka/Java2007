package course1.lesson3;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {
        int[] array = new int[5];
        int[] array2 = array;//две переменные ссылаются на один массив
        printArray(array);
        array[2] = 199;
        array[array.length - 1] = 100;

        for (int i = 0; i < array.length; i++) {
            array[i] = 100 + i * 100;
        }

        printArray(array);

        int[] arr = {1, 2, 3, 4, 5};

        printArray(arr);

        String[] strings = new String[10];

        System.out.println(Arrays.toString(strings));
        Arrays.fill(strings, "a"); //заполнит массив весь значением по умолчанию

        boolean[] booleans = {};
        System.out.println(Arrays.toString(booleans));

        int integer = 100;
        method1(integer);
        System.out.println("integer = " + integer);

        int[] integers = {1,2,3,4,5,6};
        method1(integer);
        System.out.println(Arrays.toString(integers));

    }

    public static void method1(int a) {
        a = a * 10;
    }

    public static void method1(int[] a) {
        a[2]= 100500;
    }

    public static void printArray(int @NotNull [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }


}
