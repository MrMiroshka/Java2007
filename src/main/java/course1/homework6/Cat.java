package course1.homework6;

public class Cat extends Animal {
    @Override
    //допускаем что длинна указывается в целых числах, не float
    public void run(int length) {
        if (length > 0 && length <= 200) {
            System.out.println(this.getName() + "  пробежал(а) " + length + " м.");
        } else {
            System.out.println("Не верно указана длина препятствия для кошки - " + getName());
        }
    }

    @Override
    //допускаем что длинна указывается в целых числах, не float
    public void swim(int length) {
        System.out.println(this.getName() + "  - кот, у нас коты не умеют плавать!");
    }

    protected static int count;


    public static int getCount() {
        return count;
    }

    public Cat() {
        this("");

    }

    public Cat(String name) {
        count++;
        if (name == null || name.isEmpty() || name.length() == 0) {
            setName("Имя не изместно - кошка под №" + count);
        } else {
            setName(name);
        }
    }
}
