package course1.homework7;

import java.util.Random;

/**
 * Домашнее задание №7 курс Java 1
 *
 * @author Miroshnichenko Igor
 * @version 1.7
 * created on 2022-01-26
 */
public class hwApp {
    static final Random random = new Random();

    public static void main(String[] args) {
       /*
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(100);
        plate.info();
        cat.eat(plate);
        plate.info();*/


        //задание 5 и 6
        //массив содержит от 2 до 102 котов
        Cat[] arrayCats = new Cat[random.nextInt(100) + 2];
        Plate plateGeneral = new Plate(random.nextInt(3000) + 1);

        plateGeneral.info();
        System.out.println("***************************************");
        //ради демонстации метода - добавления еды в тарелку
        //добавим еду только один раз, если не хватило первому попавшемуся котенку
        boolean flagEmptyPlate = false;

        for (int i = 0; i < arrayCats.length; i++) {
            arrayCats[i] = new Cat("Кот №" + (i + 1), random.nextInt(116) + 1);
            if (!arrayCats[i].eat(plateGeneral) && !flagEmptyPlate) {
                flagEmptyPlate = true;
                System.out.println("***************************************");
                System.out.println("Еды не хватило котенку - " + arrayCats[i].getName() + "!");
                System.out.println("В тарелке осталось - " + plateGeneral.getFood() + " единиц еды!");
                int tempValue = random.nextInt(3000) + 1;
                System.out.println("Добавляем еду - " + tempValue + " единиц, но только один раз!!!");
                plateGeneral.addFood(tempValue);
                plateGeneral.info();
                arrayCats[i].eat(plateGeneral);
                System.out.println("***************************************");
            }
            arrayCats[i].info();
        }


    }

}
