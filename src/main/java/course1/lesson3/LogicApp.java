package course1.lesson3;

public class LogicApp {
    public static void main(String[] args) {
        //или   ||    |
        // 0 0 = 0
        // 0 1 = 1
        // 1 0 = 1
        // 1 1 = 1
        //и     &&    &
        // 0 0 = 0
        // 0 1 = 0
        // 1 0 = 0
        // 1 1 = 1
        //не    !=
        int a = 10;
        if (isPositive(a)&&isZero(a)){
            System.out.println("Положительно и не 0");
        }

        if(!isPositive(a)||isZero(a)){
            System.out.println("");
        }
    }

    public static boolean isPositive(int val){
        return val >=0;
    }

    public static boolean isZero(int val){
        return val==0;
    }
}
