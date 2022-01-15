package course1.lesson4;

import java.util.*;
import java.util.stream.Collectors;

public class TsakApp {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4};
        reversArray(array);
        System.out.println(Arrays.toString(getNewArray(array)));
        System.out.println(Arrays.toString(getNewArray(new int[]{3,4,5,3,5,6})));
        //Задача
        //дан массивцелых числе. Удалить все не уникальные значения кроме последнего
        //{3,4,5,3,5,6} -> {4,3,5,6}
        //{3,4,5,3,5,3} -> {4,5,3}
        List<Integer> list = Arrays.asList(new Integer[]{3,4,5,6,6,5,4,1});
        Collections.reverse(list);
        System.out.println(list.stream().distinct().collect(Collectors.toList()));


    }

    public static void reversArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
    }

    public static int[] getNewArray(int[] array) {
        int[] result = new int[0];
        for (int i = array.length - 1; i >= 0; i--) {
            result = addValue(result, array[i]);
        }
        return result;
    }

    //[5,6] 5 -> [5,6]
    //[5,6] 3 -> [3,5,6]
    public static int[] addValue(int[] array, int value) {
        if (arrayContainsValue(array, value)) {
            return array;
        }
        int[] result = new int[array.length + 1];
        result[0] = value;
        for (int i = 0; i < array.length; i++) {
            result[i + 1] = array[i];
        }
        return result;
    }

    /**
     * Провекра что массив содержит значение
     *
     * @param array
     * @param value
     * @return true, если содержит
     */
    public static boolean arrayContainsValue(int[] array, int value) {
        for (int arr : array) {
            if (arr == value) {
                return true;
            }
        }
        return false;
    }

    public static Integer[] getNewArray2(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            if (!list.contains(array[i])) {
                list.add(array[i]);
            }
        }
        return list.toArray(new Integer[0]);
    }

}
