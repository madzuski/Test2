package pl.kurs.zadanie03.services;


import pl.kurs.zadanie03.datatypes.Employee;
import pl.kurs.zadanie03.datatypes.Person;
import pl.kurs.zadanie03.datatypes.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PersonService {

    public Person findHighestIncomePerson(List<Person> people) {
        return people.stream()
                .max(Comparator.comparingDouble(Person::getIncome))
                .orElseThrow();
        //optionale zwroc
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
                BufferedWriter writer = new BufferedWriter(fw)
        ) {
            for (Person person : people) {
                if (person instanceof Student) {
                    Student student = (Student) person;
                    writer.write("STUDENT;" + student.getFirstName() + ";" + student.getLastName() + ";" +
                            student.getPesel() + ";" + student.getCity() + ";" +
                            student.getGroup() + ";" + student.getIncome());
                } else if (person instanceof Employee) {
                    Employee employee = (Employee) person;
                    writer.write("EMPLOYEE;" + employee.getFirstName() + ";" + employee.getLastName() + ";" +
                            employee.getPesel() + ";" + employee.getCity() + ";" +
                            employee.getPosition() + ";" + employee.getIncome());
                }
                writer.newLine();
            }
        }
    }

    public List<Person> readPeopleFromFile(String filename) throws IOException {
        List<Person> people = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(new FileReader(filename))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 7) {
                    continue; // 7 zmiennych
                }

                switch (parts[0]) {
                    case "STUDENT":
                        people.add(new Student(
                                parts[1],  // firstName
                                parts[2],  // lastName
                                parts[3],  // pesel
                                parts[4],  // city
                                parts[5],  // group
                                Double.parseDouble(parts[6])  // scholarship/income
                        ));
                        break;
                    case "EMPLOYEE":
                        people.add(new Employee(
                                parts[1],  // firstName
                                parts[2],  // lastName
                                parts[3],  // pesel
                                parts[4],  // city
                                parts[5],  // position
                                Double.parseDouble(parts[6])  // salary/income
                        ));
                        break;
                    default:
                        // Skip unknown person types
                        break;
                }
            }
        } catch (NumberFormatException e) {
            throw new IOException("Error parsing numeric values from file", e);
        }
        return people;
    }
}