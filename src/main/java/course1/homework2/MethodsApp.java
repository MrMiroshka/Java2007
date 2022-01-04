package course1.homework2;

/**
 * Домашнее задание №2 курс Java 1
 *
 * @author Miroshnichenko Igor
 * @version 1.2
 * created on 2021-12-31
 */
public class MethodsApp {
    public static void main(String[] args) {
        //генерируем "случайные" два целых числа
        int a = (int) (Math.random() * 30 - 15);
        int b = (int) (Math.random() * 30 - 15);

        //задание 1
        System.out.printf("Вхождение суммы чесел a = %d и b = %d в множество [10..20] = %b \n", a, b, isIncludes(a, b));
        System.out.println();

        //задание 2
        isPositiveNumber(a);
        System.out.println();

        //задание 3
        try {
            System.out.printf("Число b = %d, отрицательное = %b \n", b, isNegativeNumber(b));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();

        //задание 4
        printStrings("Печатай меня полностью...))", (int) (Math.random() * 9 - 4));
        System.out.println();

        //задание 5
        try {
            int year = (int) (Math.random() * 5000 - 2000);
            System.out.printf("Год = %d является високосным = %b \n", year, isLeap(year));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * Метод проверяет вхождение (a+b) в множество [10..20].
     *
     * @param a - целое число
     * @param b - целое число
     * @return - возвращает true/false
     */
    public static boolean isIncludes(int a, int b) {
        if (10 <= (a + b) && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод печатает в консоли, в зависимости от передаваемого числа - "а",
     * положительное или отрицательное оно.
     *
     * @param a целое число
     */
    public static void isPositiveNumber(int a) {
        if (a >= 0) {
            System.out.println("Передали положительное число a = " + a);
        } else {
            System.out.println("Передали отрицательное число a = " + a);
        }
    }

    /**
     * Метод вычисляет отицательное или положительное число "а"
     *
     * @param a целое число
     * @return возвращает true/false
     */
    public static boolean isNegativeNumber(int a) throws Exception {
        if (a < 0) {
            return true;
        } else if (a > 0) {
            return false;
        } else {
            //т.к. в задании номер 3 не указано куда относить 0, действуем по правилам математики
            // (0 - неотрицательное и неположительное)
            throw new Exception("число а = 0 - неотрицательное и неположительное");
        }
    }

    /**
     * Метод печатает n раз строку str
     *
     * @param str строка
     * @param n   количество раз печати строки str в консоле
     */
    public static void printStrings(String str, int n) {
        if (n <= 0) {
            System.out.printf("Строку не возможно напечатать %d раз \n", n);
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    /**
     * Метод, который определяет, является ли год високосным
     *
     * @param year год
     * @return возвращает true/false
     */
    public static boolean isLeap(int year) throws Exception {
        //т.к. в задании номер 5 не указан диапозон числа т.е. число может быть и отрицательным и 0 вводим проверку
        if (year <= 0) {
            throw new Exception("год = " + year + " <= 0, считаем что дата введена не верна. Валидный год > 0");
        }

        if (year % 4 == 0) {
            if (year % 400 == 0) {
                return true;
            } else if (year % 100 == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
