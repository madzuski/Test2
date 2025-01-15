package pl.kurs.zadanie01.services;

import pl.kurs.zadanie01.datatypes.Child;
import pl.kurs.zadanie01.datatypes.Mother;
import pl.kurs.zadanie01.datatypes.Sex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChildService {


    public static List<Child> readChildrenFromFilePath(String path, Map<Integer, Mother> mothersMap) {
        List<Child> children = new ArrayList<>();
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Child childFromString = createChildFromString(line, mothersMap);
                children.add(childFromString);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return children;
    }

    private static Child createChildFromString(String line, Map<Integer, Mother> mothersMap) {
        String[] array = line.split(" ");
        Sex[] sexValues = Sex.values();

        return new Child(
                Integer.parseInt(array[0]), //newbornID
                sexValues[(chooseSex(array[1]))], //sex
                array[2], //firstName
                LocalDate.parse(array[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")), //birthdate
                Integer.parseInt(array[4]), //weight
                Integer.parseInt(array[5]), //height
                mothersMap.get(Integer.parseInt(array[6]))); // Mother mother
    }

    private static int chooseSex(String sex) {
        if (sex.equals("c")) {
            return 0;
        } else {
            return 1;
        }
    }

    //a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.

    public static List<Child> getTallestChildren(List<Child> children) {
        List<Child> tallestKids = new ArrayList<>();
        tallestKids.add(getTallestGirl(getGirlsFromList(children)));
        tallestKids.add(getTallestBoy(getBoysFromList(children)));
        return tallestKids;
    }

    private static List<Child> getGirlsFromList(List<Child> children) {
        List<Child> girls = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getSex() == Sex.FEMALE) {
                girls.add(children.get(i));
            }
        }
        return girls;
    }

    private static List<Child> getBoysFromList(List<Child> children) {
        List<Child> boys = new ArrayList<>();
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getSex() == Sex.MALE) {
                boys.add(children.get(i));
            }
        }
        return boys;
    }

    private static Child getTallestGirl(List<Child> girls) {
        Child tallestGirl = girls.get(0);
        for (int i = 0; i < girls.size(); i++) {
            if (girls.get(i).getHeight() > tallestGirl.getHeight()) {
                tallestGirl = girls.get(i);
            }
        }
        return tallestGirl;
    }

    private static Child getTallestBoy(List<Child> boys) {
        Child tallestBoy = boys.get(0);
        for (int i = 0; i < boys.size(); i++) {
            if (boys.get(i).getHeight() > tallestBoy.getHeight()) {
                tallestBoy = boys.get(i);
            }
        }
        return tallestBoy;
    }

    //b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.

    public static Map<DayOfWeek, Integer> getDaysWithMostBirthsMap(List<Child> children) {

        Map<DayOfWeek, Integer> dayOfWeekIntegerMap = new HashMap<>();
        int[] birthCounterForDayOfWeekArray = new int[7];
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();
        for (Child child : children) {
            DayOfWeek dayOfWeek = child.getBirthDate().getDayOfWeek();
            birthCounterForDayOfWeekArray[dayOfWeek.getValue() - 1]++;
        }

        for (int i = 0; i < dayOfWeeks.length; i++) {
            dayOfWeekIntegerMap.put(dayOfWeeks[i], birthCounterForDayOfWeekArray[i]);
        }
        return dayOfWeekIntegerMap;
    }

    //d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.

    public static List<Child> getGirlsInheritingMothersName(List<Child> children) {
        List<Child> matchingGirls = new ArrayList<>();
        for (Child child : children) {
            if (child.getSex() == Sex.FEMALE && child.getFirstName().equalsIgnoreCase(child.getMother().getFirstName())) {
                matchingGirls.add(child);
            }
        }
        return matchingGirls;
    }

}































