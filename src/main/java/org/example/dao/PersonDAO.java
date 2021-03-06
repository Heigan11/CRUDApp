package org.example.dao;

import org.example.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Alex", 24, "alex@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Leo", 52, "leo@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Ann", 18, "ann@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kate", 34, "kate@mail.ru"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(Person newPerson){
        Person oldPerson = show(newPerson.getId());
        oldPerson.setName(newPerson.getName());
        oldPerson.setAge(newPerson.getAge());
        oldPerson.setEmail(newPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }


}
