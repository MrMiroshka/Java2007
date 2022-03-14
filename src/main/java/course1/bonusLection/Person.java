package course1.bonusLection;

import javax.swing.plaf.basic.BasicOptionPaneUI;

public class Person {
    private final String name;
    private final int age;
    private final String position;
    private final double salary;

    private Person(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.position = builder.position;
        this.salary = builder.salary;
    }

   /* public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }*/

    public String getName() {
        return name;
    }

  /*  public void setName(String name) {
        this.name = name;
    }*/

    public int getAge() {
        return age;
    }
/*
    public void setAge(int age) {
        this.age = age;
    }*/

    @Override
    public String toString() {
        //return super.toString();
        return "Person{"+
                "name="+name + '\''+
                "age="+ age+
                "salary"+salary+
                "position"+position+
                '}';
    }



    public static Builder builder(){
        return new Builder();
    }

    public void info(){
        System.out.println(this);
    }

    public static class Builder{
        private String name;
        private int age;
        private String position;
        private double salary;

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withAge(int age){
            this.age = age;
            return this;
        }

        public Builder withSalary(double salary){
            this.salary=salary;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

        public Builder fromPerson(Person person){
           return new Builder().withName(person.name).withSalary(person.salary);
        }

    }
}
