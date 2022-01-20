package course1.lesson6;

public class Cabriolet extends Car {

    boolean hasHardTop;

    public Cabriolet(String model, int year, boolean hasHardTop) {
        super(model,year);
        this.hasHardTop = hasHardTop;
    }



    public boolean isHasHardTop() {
        return hasHardTop;
    }

    public void setHasHardTop(boolean hasHardTop) {
        this.hasHardTop = hasHardTop;
    }
}
