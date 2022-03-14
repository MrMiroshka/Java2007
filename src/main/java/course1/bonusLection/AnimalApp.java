package course1.bonusLection;

import java.util.Random;

public class AnimalApp {
    public static void main(String[] args) {
        Animal[] animals = new Animal[10];
        Random random = new Random();
        for (int i = 0; i < animals.length; i++) {
            switch (i%3){
                case 0:
                    animals[i] = new Cat(random.nextInt(300), random.nextInt(10));
                    break;
                case 1:
                    animals[i] = new Dog();
                    break;
                case 2:
                    animals[i] = new Elephant();
                    break;
            }
        }

        for (Animal animal:animals) {
            System.out.println(animal.getClazz());
            animal.run(random.nextInt(100));
            animal.swim(random.nextInt(100));
        }

        System.out.println("Всего создали животных - "+Animal.animalCount);
    }
}
