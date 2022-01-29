package course1.homework5;

public class Cheks {
    /**
     * Проверяет, является ли символ буквой (англ. раскладка)
     *
     * @param simvol проверяемый символ
     * @return если символ = буква вернет True, иначе False
     */
    public static boolean isLetter(char simvol) {
        if (simvol < 'A' || (simvol > 'Z' && simvol < 'a') || (simvol > 'z') || simvol == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Проверяет, является ли символ цифрой
     *
     * @param simvol проверяемый символ
     * @return если символ = цифра вернет True, иначе False
     */
    public static boolean isNumber(char simvol) {
        if (simvol < '0' || simvol > '9' || simvol == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Проверяет входит ли symvol в подмножество array
     *
     * @param array  набор символов
     * @param simvol проверяемый символ
     * @return если символ входит в множество вернет True, иначе False
     */
    public static boolean isСharacterSet(char[] array, char simvol) {
        if (array.length == 0 || simvol == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == simvol) {
                count++;
                break;
            }
        }

        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Проверяет все ли символы в строке буквы
     *
     * @param str строка, которую проверяем
     * @return во
     */
    public static boolean isValidString(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет является ли строка номер телефона
     *
     * @param str - проверяемая строка
     * @return возвращает True, если строка str - это набор цирф. Иначе False
     */
    public static boolean isValidPhoneNumber(String str) {
        //13 чисел так как есть например код страны - "+45"
        if (str == null || str.isEmpty() || str.length() >= 13 || str.length() < 6) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!isNumber(str.charAt(i))) {
                if (i == 0) {
                    if (!isСharacterSet(new char[]{'+'}, str.charAt(i))) {
                        return false;
                    }
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    /**
     * Проверяет все ли символы в строке буквы и символы из множества (array)
     *
     * @param str проверяемая строка
     * @return возвращает True, если в строке буквы и символы из множества (array). Иначе False
     */
    public static boolean isValidStringChSet(String str, char[] array) {

        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!isNumber(c)) {
                if (!isLetter(c)) {
                    if (!isСharacterSet(array, c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
