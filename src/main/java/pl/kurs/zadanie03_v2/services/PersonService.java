package pl.kurs.zadanie03_v2.services;


import pl.kurs.zadanie03_v2.datatypes.Employee;
import pl.kurs.zadanie03_v2.datatypes.Person;
import pl.kurs.zadanie03_v2.datatypes.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public Person findHighestIncomePerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingDouble(Person::getIncome))
                .orElseThrow();
    }

    public int countWomen(List<Person> people) {
        int count = 0;
        for (Person person : people) {
            if ("Female".equals(person.getPlec())) {
                count++;
            }
        }
        return count;
    }

    public void savePeopleToFile(List<Person> people, String filename) throws IOException {
        try (
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (Person person : people) {
                bw.write(person.toCSV());
                bw.newLine();
            }
        }
    }

    public List<Person> readPeopleFromFile(String filename) throws IOException {
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 7) {
                    continue;
                }
                String type = parts[0];
                String firstName = parts[1];
                String lastName = parts[2];
                String pesel = parts[3];
                String city = parts[4];
                String assignment = parts[5];
                double income = Double.parseDouble(parts[6]);

                switch (type) {
                    case "STUDENT":
                        people.add(new Student(firstName, lastName, pesel, city, assignment, income));
                        break;
                    case "EMPLOYEE":
                        people.add(new Employee(firstName, lastName, pesel, city, assignment, income));
                        break;
                }
            }
        } catch (NumberFormatException e) {
            throw new IOException("Error parsing numeric values from file", e);
        }
        return people;
    }
}