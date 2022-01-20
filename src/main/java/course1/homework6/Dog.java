package course1.homework6;

public class Dog extends Animal {
    @Override
    //допускаем что длинна указывается в целых числах, не float
    public void run(int length) {
        if (length > 0 && length <= 500) {
            System.out.println(this.getName() + "  пробежал(а) " + length + " м.");
        } else {
            System.out.println("Не верно указана длина препятствия! Для собаки - "+ getName());
        }
    }

    @Override
    //допускаем что длинна указывается в целых числах, не float
    public void swim(int length) {
        if (length > 0 && length <= 10) {
            System.out.println(this.getName() + "  проплыл(а) " + length + " м.");
        } else {
            System.out.println("Не верно указана длина препятствия! Для собаки - "+ getName());
        }
    }

    private static int count;

    public static int getCount() {
        return count;
    }

    public Dog() {
        this("");

    }

    public Dog(String name) {
        count++;
        if (name == null || name.isEmpty()||name.length()==0) {
            setName("Имя не изместно - собака под №" + count);
        } else {
            setName(name);
        }
    }
}
