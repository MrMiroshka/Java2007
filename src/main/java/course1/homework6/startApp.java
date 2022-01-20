package course1.homework6;

/**
 * Домашнее задание №6 курс Java 1
 *
 * @author Miroshnichenko Igor
 * @version 1.6
 * created on 2022-01-21
 */
public class startApp {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog("Мухтар");
        Cat cat1 = new Cat();
        Cat cat2 = new Cat("Мурзик");
        Cat cat3 = new Cat("Тишка");

        System.out.println("Кошки");
        cat1.run(6);
        cat2.run(-1);
        cat3.swim(5);

        System.out.println();
        System.out.println("Собаки");
        dog1.run(122);
        dog1.swim(22);
        dog2.swim(5);

        System.out.println();
        System.out.println("Всего было создано котов: " + Cat.getCount());
        System.out.println("Всего было создано собак: " + Dog.getCount());


    }
}
