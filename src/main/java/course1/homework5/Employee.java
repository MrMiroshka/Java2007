package course1.homework5;

import course1.lesson2.PrintUtil;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

public class Employee {
    private String firstName;
    private String secondName;
    private String patronymic;
    private String position;
    private String email;
    private String phone;
    private float salary;
    private byte age;


    public Employee(String firstName, String secondName, String patronymic, String position, String email, String phone, float salary, byte age) {
        setFirstName(firstName);
        setSecondName(secondName);
        setPatronymic(patronymic);
        setPosition(position);
        setEmail(email);
        setPhone(phone);
        setSalary(salary);
        setAge(age);
    }

    public Employee(String firstName, String secondName, String patronymic, String position, String email, String phone, float salary) {
        this(firstName, secondName, patronymic, position, email, phone, salary, (byte) 18);
    }

    public Employee(String firstName, String secondName, String patronymic, String position, String phone, float salary) {
        this(firstName, secondName, patronymic, position, "No mail", phone, salary, (byte) 18);
    }




    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (Cheks.isValidString(firstName)) {
            this.firstName = firstName;
        } else {
            System.out.println("Имя - \'" + firstName + "\' является не верным. Имя не сохранено");
        }
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if (Cheks.isValidString(secondName)) {
            this.secondName = secondName;
        } else {
            System.out.println("Фамилия - \'" + secondName + "\' является не верной. Фамилия не сохранено");
        }
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (Cheks.isValidString(patronymic)) {
            this.patronymic = patronymic;
        } else {
            System.out.println("Отчество - \'" + patronymic + "\' является не верной. Отчество не сохранено");
        }

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (Cheks.isValidString(position)) {
            this.position = position;
        } else {
            System.out.println("Должность - \'" + position + "\' является не верной. должность не сохранена");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            this.email = "No mail";
            return;
        }

        if (Cheks.isValidStringChSet(email, new char[]{'@', '.'}) || email.equals("No mail")) {
            this.email = email;
        } else {
            System.out.println("Email - \'" + email + "\' является не верным. Email не сохранен");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (Cheks.isValidPhoneNumber(phone)) {
            this.phone = phone;
        } else {
            System.out.println("Номер телефона - \'" + phone + "\' является не верным. Номер телефона не сохранен");
        }
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if (salary >= 0 && salary < 100000000) {
            this.salary = salary;
        } else {
            System.out.println("Зарплата - \'" + salary + "\' является не верной. Зарплата не сохранен");
        }
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        if (age > 17 && age < 100) {
            this.age = age;
        } else {
            System.out.println("Возраст - \'" + age + "\' является не верным. Возраст не сохранен");
        }
    }

    /**
     * Выводит информацию о сотруднике
     * @throws IllegalAccessException исключение  бросается, когда в настоящий момент у метода нет доступа к определению указанного поля
     */
    public void info() throws IllegalAccessException {
        System.out.println();
        System.out.println("***************************");
        Field[] fields = this.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName().toString() + ": " + fields[i].get(this));
        }
    }
}
