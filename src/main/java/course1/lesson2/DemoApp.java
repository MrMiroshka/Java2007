package course1.lesson2;

/**
 * Создать пол 6х6 т заполнить его
 */
public class DemoApp {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                //if (j>4){
                if (i == j) {
                    System.out.print(" ");
                } else if (i < j) {
                    System.out.print("* ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }


}
