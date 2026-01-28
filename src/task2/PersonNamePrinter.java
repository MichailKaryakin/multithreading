package task2;

import java.util.List;

public class PersonNamePrinter implements Runnable {
    List<Person> people;

    public PersonNamePrinter(List<Person> people) {
        this.people = people;
    }

    @Override
    public void run() {
        for (Person person : people) {
            System.out.println(person.getName());
        }
    }
}
