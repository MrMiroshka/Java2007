package course1.lesson6;

public class Car extends Transport{
    protected String model;
    protected int year;

    public Car(String model, int year) {
        System.out.println("This is a car constructur");
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    void printName(){
        System.out.println("This is a Car");
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    void info(){
        System.out.println(this);
    }
}
