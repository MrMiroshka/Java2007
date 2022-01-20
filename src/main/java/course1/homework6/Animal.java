package course1.homework6;

public abstract class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null || !name.isEmpty() || name.length() == 0) {
            this.name = name;
        } else {
            System.out.println("Не верно указано имя!");
        }
    }

    //допускаем что длинна указывается в целых числах, не float
    public void run(int length) {
        if (length > 0) {
            System.out.println(this.name + " пробежал " + length + " м.");
        } else {
            System.out.println("Не верно указана длина препятствия!");
        }
    }

    //допускаем что длинна указывается в целых числах, не float
    public void swim(int length) {
        if (length > 0) {
            System.out.println(this.name + " проплыл " + length + " м.");
        } else {
            System.out.println("Не верно указана длина препятствия!");
        }
    }


}
