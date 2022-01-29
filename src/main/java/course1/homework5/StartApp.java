package course1.homework5;

import javax.swing.*;
import java.time.Period;

/**
 * Домашнее задание №5 курс Java 1
 *
 * @author Miroshnichenko Igor
 * @version 1.5
 * created on 2022-01-21
 */
public class StartApp {
    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivan","Ivanov","Ivanovich", "Engineer", "ivivan@mailbox.com", "8923123121", (float) 30000, (byte)30);
        persArray[1] = new Employee("Sergey","Bikov","Valrivich", "Engineer", "iv231an@mailbox.com", "+792312312", (float) 300, (byte)45);
        persArray[2] = new Employee("Igor","Elnikov","Aleksandrovich", "Engineer", "ivsdd22@mailbox.com", "892312312", (float) 50000, (byte)20);
        persArray[3] = new Employee("Aleksandr","Kopec","Artemovich", "Engineer", "addsad3van@mailbox.com", "892312312", (float) 45000, (byte)50);
        persArray[4] = new Employee("Mihail","Sapozhnikov","", "Engineer", "sdas3n@mailbox.com", "+792312312", (float) 3000, (byte)24);


        for (Employee pers: persArray) {
            if (pers.getAge() > 40){
                try {
                    pers.info();
                }
                catch (Exception exp){
                    System.out.println(exp);
                }
            }
        }
    }

}
