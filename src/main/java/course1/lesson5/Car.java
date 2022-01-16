package course1.lesson5;

public class Car {
    //fields

    private static int weelsNumber = 0;
    private static int wheelsNumber;
    private String modelFull;
    private String model;
    private int year;
    private boolean wasCrashed;

    /**
     * Выводит на экран информацию о машине
     */
    public void info() {
        System.out.println("Molad = " + model + " year = " + year + " wasCrashed = " + wasCrashed);
    }

    public void printModel() {
        System.out.println(model);
    }

    public static int getWeelsNumber() {
        return weelsNumber;
    }

    public static int getWheelsNumber() {
        return wheelsNumber;
    }

    public boolean getWasCrashed() {
        return wasCrashed;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public boolean isWasCrashed() {
        return wasCrashed;
    }

    public static void setWeelsNumber(int weelsNumber) {
        Car.weelsNumber = weelsNumber;
    }

    public static void setWheelsNumber(int wheelsNumber) {
        Car.wheelsNumber = wheelsNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        }else {
            System.out.println("Error");
        }
    }

    public void setWasCrashed(boolean wasCrashed) {
        this.wasCrashed = wasCrashed;
    }

    /**
     * Попал в аварию
     */
    public void crash(){
        System.out.println("car was crached");
        wasCrashed=true;
    }

    public void repair(){
        if (wasCrashed) {
            wasCrashed = false;
            System.out.println("was repaired");
        }else {
            System.out.println("nothing toi repair");
        }
    }

    public void printModelNTimes(int n){
        for (int j = 0; j < n; j++) {
            System.out.println(model);
        }
    }

    public static void staticInfo(){

    }

    public Car(String modelFull, String model, int year, boolean wasCrashed) {
        this.modelFull = modelFull;
        this.model = model;
        this.year = year;
        this.wasCrashed = wasCrashed;
    }

    public Car(String model_, int year_, boolean wasCrashed_) {
        //this.modelFull = modelFull;
        model = model_;
        year = year_;
        wasCrashed = wasCrashed_;
    }

    public Car(){

    }
    public Car(String model_, int year_){
        this(model_,year_,false);
        this.model +="from overrided constructor";
       // model = model_;
       //  year = year_;
       // wasCrashed = false;
    }

    public Car(String model){
        this(model,2020);
    }
}
