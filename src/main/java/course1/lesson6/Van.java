package course1.lesson6;

//is a
public class Van extends Car{
    //String modal;

    int seats;

    public Van(String modal, int year, int seats) {

        super(modal,year);
        System.out.println("This is a van constructur");
        this.seats = seats;
    }



    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    void printName(){
        System.out.println("This is a Van");
    }

}
