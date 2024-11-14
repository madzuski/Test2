package pl.kurs.zadanie03.services;

import pl.kurs.zadanie01.datatypes.Child;
import pl.kurs.zadanie03.datatypes.Person;
import pl.kurs.zadanie03.datatypes.Sex;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SchoolService {


    public Person findPersonWithHighestIncome(Person[] people) {

        Person highestIncomePerson = people[0];
        for (Person person : people) {
            if (person != null && person.getIncome() > highestIncomePerson.getIncome()) {
                highestIncomePerson = person;
            }
        }
        return highestIncomePerson;
    }

    public int countFemales(Person[] people) {
        int counter = 0;
        for (Person person : people) {
            if (person != null && person.getSex().equals(Sex.FEMALE)) {
                counter++;
            }
        }
        return counter;
    }

    public void saveToFile(Person[] people, String fileName) {
        try (
                FileWriter fw = new FileWriter(fileName, true);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            for (Person person : people) {
                bw.write(
                        person.getFirstName() +
                                " " + person.getLastName() +
                                " " + person.getPesel() +
                                " " + person.getCity() +
                                " " + person.getDepartment() +
                                " " + person.getIncome()
                );
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

//    public static List<Person> readChildrenFromFilePath(String path) {
//        List<Person> people = new ArrayList<>();
//        try (
//                FileReader fr = new FileReader(path);
//                BufferedReader br = new BufferedReader(fr)
//        ) {
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                Person personFromString = createPersonFromString(line);
//                people.add(personFromString);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return people;
//    }
//
//    private static Person createPersonFromString(String line) {
//        String[] array = line.split(" ");
//
//        return new Person(
//                array[0], //firstName
//                array[1], //lastName
//                array[2], //pesel
//                array[3], //city
//                array[4], //department
//                Double.parseDouble(array[5]));
//    }
}
