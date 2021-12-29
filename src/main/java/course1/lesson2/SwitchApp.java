package course1.lesson2;

public class SwitchApp {
    public static void main(String[] args) {
        checkOrderStatus2("ACCEPTED");
        checkOrderStatus2("IN_DELIVERED");
        String month = "JAN";
        //группируем месяца
        switch (month){
            case "DEC":
            case "JAN":
            case "FEB":
                System.out.println("winter");
                break;
        }
    }

    public static void checkOrderStatus(String orderStatus){
        if (orderStatus.equals("ACCEPTED")){
            System.out.println("Принят");
        }else if(orderStatus.equals("DELIVERED")){
            System.out.println("Доставлено");
        }else {
            System.out.println("Неизвестный статус заказа");
        }
    }

    public static void checkOrderStatus2(String orderStatus){
        switch (orderStatus){
            case "ACCEPTED":{
                System.out.println("Принят");
                break;
            }
            case "DELIVERED":{
                System.out.println("Доставлен");
                break;
            }
            case "SHIPED":
            case "IN_DELIVERY":{
                System.out.println("В доставке");
                break;
            }
            default:{
                System.out.println("Неизвестный статус заказа");
            }
        }
    }
}
