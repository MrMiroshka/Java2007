package course1.homework7;

public class Cat {
    private String name;
    private int appetite;
    //т.к. по заданию при создании котов сытость = false, а java при создании объекта,
    // поля не инициализированные в явном виде, инициализирует значениеями по умолчанию. boolean =false,
    //то не инициализируем это поле в явном виде, т.к. оно и так получит по умолчанию нужное нам значение
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public boolean eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            satiety = true;
            return true;
        }
        return false;
    }

    public void info() {
        System.out.println("Имя кота:              " + name);
        System.out.println("Коту для сытости надо: " + appetite);
        System.out.println("Сыт ли кот:            " + satiety);
        System.out.println("----------------------------");
    }
}
