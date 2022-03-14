package course1.bonusLection;

public class Cat extends Animal{

    private int maxRunDistance;
    private int maxSwimDistance;

    @Override
    public void swim(int distance) {
        System.out.println("не умеют плавать");
    }

    @Override
    int getMaxRunDistance() {
        return maxRunDistance;
    }

    @Override
    int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public Cat(int maxRunDistance, int maxSwimDistance) {
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    @Override
    public void run(int distance) {
        if(distance>maxRunDistance){
            return;
        }else{
            super.run(distance);
        }

    }
}
