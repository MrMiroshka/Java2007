package course1.bonusLection;

import course1.lesson6.ExampleApp;

import java.util.Random;

public class PersonApp {
    public static void main(String[] args) {
        Random randon = new Random();
        Person[] persons = new Person[10];

        for (int i = 0; i < persons.length; i++) {
            Person.Builder builder = new Person.Builder();
            builder.withName("Person\" + i").withAge(randon.nextInt(70));
            if(i%3==0){
                builder.withSalary(randon.nextInt(1000));
            }
            persons[i]=builder.build();
            //persons[i] = new Person("Person" + i, randon.nextInt(70));
        }

        for (Person person : persons) {
            if (person.getAge() < 40) {
                continue;
            }
            person.info();
        }

        Person person = Person.builder().withName("name").withAge(2).build();
    }
}
