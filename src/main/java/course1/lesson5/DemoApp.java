package course1.lesson5;

import java.util.Arrays;

public class DemoApp {

    public static void main(String[] args) {

        System.out.println("Args"+ Arrays.toString(args));

        Car car = new Car();
        Car car2 = new Car();
        Car car3 = car;

        car.setModel("Dodge");
        car.setYear(2020);
        car.setWeelsNumber(4);

        //car.year = 2020;
        //car.weelsNumber = 4;


        car.crash();
        car.repair();

        //Car.info() - нельзя т.к. не статический
        car.info();
        car.printModel();
        //надо прятать все поля через геттеры и сеттеры
        String arModel = car.getModel();
        System.out.println("Molad = " + car.getModel() + " year = " + car.getYear() + " wasCrashed = " + car.getWasCrashed() + " weelsNumber = " + car.getWasCrashed());

        //System.out.println("Molad = " + car.model + " year = " + car.year + " wasCrashed = " + car.wasCrashed + " weelsNumber = " + car.weelsNumber);

        //car2.model = "Ford";
        //car2.year = 1998;
        //car2.weelsNumber = 6;
        //System.out.println("Molad = " + car2.model + " year = " + car2.year + " wasCrashed = " + car2.wasCrashed + " weelsNumber = " + car.weelsNumber);
        //System.out.println("Molad = " + car.model + " year = " + car.year + " wasCrashed = " + car.wasCrashed + " weelsNumber = " + car.weelsNumber);


        // int wheelsNumber = Car.wheelsNumber;
        //String model = car.model;
        Car[] cars = new Car[]{car, car2};

        //создаем объект используя конструктор
        Car car4 = new Car("KIA RIО", "RIО", 2013, true);
        Car car5 = new Car("RIО", 2013, true);
        Car car6 = new Car("RIО", 2013);

        Robot[] robots = new Robot[10];
        for (int i = 0; i < robots.length; i++) {
            robots[i] = new Robot("Robot", i + 10);
        }

        for (Robot robot:robots){
            robot.info();
        }

        //cp from
        //mcdir все что почле попадает в args

    }
}
