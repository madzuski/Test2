package pl.kurs.zadanie01.app;

import pl.kurs.zadanie01.datatypes.Child;
import pl.kurs.zadanie01.datatypes.Mother;
import pl.kurs.zadanie01.services.ChildService;
import pl.kurs.zadanie01.services.MotherService;

import java.util.List;

public class HospitalRunner {
    public static void main(String[] args) {

        List<Child> childrenListFromFile = ChildService.readChildrenFromFilePath("noworodki.txt");
        childrenListFromFile.forEach(System.out::println);

        List<Mother> mothersListFromFile = MotherService.readMothersFromFilePath("mamy.txt");
//        mothersListFromFile.forEach(System.out::println);


        System.out.println("-----print specific child from file-----");
        Child child = childrenListFromFile.get(0);
        System.out.println("child = " + child);

        System.out.println("-----print specific mother from file-----");
        Mother mother = mothersListFromFile.get(0);
        System.out.println("mother = " + mother);

        String tallestChildren = ChildService.getTallestChildren(childrenListFromFile);
        System.out.println("tallestChildren = " + tallestChildren);


    }
}
