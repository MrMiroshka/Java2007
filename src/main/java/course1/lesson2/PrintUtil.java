package course1.lesson2;

public class PrintUtil {
    /**
     * Форматирует строку тремя * до и после
     * @param str строка для форматирования
     */
    public static void printFormatted(String str){
        System.out.println("***"+str+"**");
        System.out.println();
        System.out.printf("***%s***",str);
        System.out.println();
    }

    public static String getFormatted(String str){
        return "***"+str+"**";
    }
}
