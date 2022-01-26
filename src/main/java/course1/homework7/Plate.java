package course1.homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("Тарелка содержит "+this.getFood()+" единиц еды");;
    }


    public void addFood(int food) {
        if (food > 0) {
            this.food += food;
        }
    }

    public boolean decreaseFood(int countEat) {
        if (food >= countEat) {
            food -= countEat;
            return true;
        } else {
            return false;
        }
    }

}
