package course1.lesson6;

import com.sun.jdi.connect.Transport;

import java.util.Arrays;

public class RentApp {
    public static void main(String[] args) {
        Car car = new Car ("toyota",2012);
        System.out.println();
        Car van = new Van("Toyota",2010,7);
        String model = van.getModel();
        System.out.println(model);
        System.out.println();
        //System.out.println(van.);

        Car van1 = new Van("ford",2012,7);
        Car cabrio = new Cabriolet("Peugeot",2015,true);

        Car[] cars = {car,cabrio,van1};

        System.out.println(car instanceof Van);//false
        System.out.println(car instanceof Car);//true
        System.out.println(van instanceof Car);//true
        System.out.println(cabrio instanceof Van);//false
        System.out.println(cabrio instanceof Transport);//true


        for (Car c:cars){
            System.out.println(c.getModel());
        }

        System.out.println("Only vans");
        for (Car c : cars){
            if (c instanceof Van){
                Van v = (Van) c;
                System.out.println("This is a van " + c.getModel());
                System.out.println("This is a van " + v.getSeats());
            }
        }

        System.out.println();
        course1.lesson6.Transport[] transports =  {car,cabrio,van1};
        for (course1.lesson6.Transport transport : transports) {
            transport.printName();
            System.out.println(transport);

        }

        System.out.println(Arrays.toString(transports));

    }
}
