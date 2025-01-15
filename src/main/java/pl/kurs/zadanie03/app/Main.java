package pl.kurs.zadanie03.app;


import pl.kurs.zadanie03.datatypes.Employee;
import pl.kurs.zadanie03.datatypes.Person;
import pl.kurs.zadanie03.datatypes.Student;
import pl.kurs.zadanie03.services.PersonService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Student("Alice", "Smith", "12345678901", "CityA", "Group1", 1000));
        people.add(new Employee("Bob", "Johnson", "23456789012", "CityB", "Manager", 2000));
        people.add(new Student("Maria", "Garcia", "98765432100", "CityC", "Group2", 1200));
        people.add(new Employee("John", "Williams", "87654321911", "CityD", "Developer", 2500));
        people.add(new Student("Eva", "Brown", "76543210822", "CityE", "Group1", 900));
        people.add(new Employee("Sarah", "Davis", "65432109744", "CityF", "Analyst", 2200));
        people.add(new Student("Michael", "Miller", "54321098633", "CityG", "Group3", 1100));
        people.add(new Employee("Emma", "Wilson", "43210987600", "CityH", "Engineer", 2800));
        people.add(new Student("David", "Taylor", "32109876511", "CityI", "Group2", 950));

        PersonService personService = new PersonService();

        Person highestIncomePerson = personService.findHighestIncomePerson(people);
        System.out.println("Person with highest income: " + highestIncomePerson);

        int numberOfWomen = personService.countWomen(people);
        System.out.println("Number of women: " + numberOfWomen);

        try {
            personService.savePeopleToFile(people,"people.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Person> peopleFromFile = new ArrayList<>();

        try {
            for (Person person : personService.readPeopleFromFile("people.txt")) {
                System.out.println(person);
                peopleFromFile.add(person);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}