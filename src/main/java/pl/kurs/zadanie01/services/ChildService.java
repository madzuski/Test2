package pl.kurs.zadanie01.services;

import pl.kurs.zadanie01.datatypes.Child;
import pl.kurs.zadanie01.datatypes.Sex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ChildService {


    public static List<Child> readChildrenFromFilePath(String path) {
        List<Child> children = new ArrayList<>();
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Child childFromString = createChildFromString(line);
                children.add(childFromString);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return children;
    }

    private static Child createChildFromString(String line) {
        String[] array = line.split(" ");
        Sex[] sexValues = Sex.values();

        return new Child(
                Integer.parseInt(array[0]), //newbornID
                sexValues[(chooseSex(array[1]))], //sex
                array[2], //firstName
                LocalDate.parse(array[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                Integer.parseInt(array[4]),
                Integer.parseInt(array[5]),
                Integer.parseInt(array[6]));
                
    }

    private static int chooseSex(String sex) {
        if (sex.equals("c")) {
            return 0;
        } else {
            return 1;
        }
    }

    //a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.
    public static String getTallestChildren(List<Child> children) {

        List<Child> boys = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getSex() == Sex.MALE) {
                boys.add(children.get(i));
            }
        }
        Child tallestBoy = boys.get(0);
        for (int i = 0; i < boys.size(); i++) {
            if (boys.get(0).getHeight() > tallestBoy.getHeight()) {
                tallestBoy = boys.get(i);
            }
        }

        List<Child> girls = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getSex() == Sex.FEMALE) {
                girls.add(children.get(i));
            }
        }
        Child tallestGirl = girls.get(0);
        for (int i = 0; i < girls.size(); i++) {
            if (girls.get(0).getHeight() > tallestGirl.getHeight()) {
                tallestGirl = girls.get(i);
            }
        }

        List<Child> tallestKids = new ArrayList<>();
        tallestKids.add(tallestGirl);
        tallestKids.add(tallestBoy);

        String tallest = "boy: " + tallestBoy.getFirstName() + tallestBoy.getHeight() + " girl: " + tallestGirl.getFirstName() + tallestGirl.getHeight();

        return tallest;
    }

//    public static int printDayWithMostBirthdays(List<Child> children) {
//
//        List<Integer> integerList = new ArrayList<>();
//        for (Child child : children) {
//            integerList.add(child.getBirthDate().getDayOfWeek());
//        }
//    }
}































