package pl.kurs.zadanie01.app;

import pl.kurs.zadanie01.datatypes.Child;
import pl.kurs.zadanie01.datatypes.Mother;
import pl.kurs.zadanie01.services.ChildService;
import pl.kurs.zadanie01.services.MotherService;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public class HospitalRunner {
    public static void main(String[] args) {

        Map<Integer, Mother> mothersMapFromFile = MotherService.readMothersFromFilePath("mamy.txt");
        List<Child> childrenListFromFile = ChildService.readChildrenFromFilePath("noworodki.txt", mothersMapFromFile);

        MotherService.assignChildrenToMothers(mothersMapFromFile.values(), childrenListFromFile);

        //a) Podaj imię i wzrost najwyższego chłopca oraz imię i wzrost najwyższej dziewczynki.
        List<Child> tallestChildren = ChildService.getTallestChildren(childrenListFromFile);
        showTallestBoyAndGirlNamesAndHigh(tallestChildren);
        System.out.println("--------------------------------");

        //b) W którym dniu tygodnia urodziło się najwięcej dzieci? Podaj dzien tygodnia i liczbe dzieci.
        Map<DayOfWeek, Integer> dayWithMostBirths = ChildService.getDaysWithMostBirthsMap(childrenListFromFile);
        showDayWithMostBirths(dayWithMostBirths);
        System.out.println("--------------------------------");

        //c) Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.
        showYoungMothersNamesWithHeavyBabies(MotherService.getYoungMothersWithHeavyBabiesList(childrenListFromFile));
        System.out.println("--------------------------------");

        //d) Podaj imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce.
        List<Child> girlsInheritingMothersName = ChildService.getGirlsInheritingMothersName(childrenListFromFile);
        showGirlsInheritingMotherName(girlsInheritingMothersName);
        System.out.println("--------------------------------");

        //e) Znajdz matki które urodziły bliźnięta.
        List<Mother> mothersWithTwins = MotherService.getMothersWithTwinsList(childrenListFromFile);
        showMothersWithTwins(mothersWithTwins);
    }

    static void showTallestBoyAndGirlNamesAndHigh(List<Child> tallestChildrenList) {
        System.out.println("girl: " + tallestChildrenList.get(0).getFirstName() + " " + tallestChildrenList.get(0).getHeight());
        System.out.println("boy: " + tallestChildrenList.get(1).getFirstName() + " " + tallestChildrenList.get(1).getHeight());
    }
    static void showDayWithMostBirths(Map<DayOfWeek, Integer> dayOfWeekIntegerMap) {
        System.out.println("Day with most births: " + dayOfWeekIntegerMap.keySet());
        System.out.println("Number of  births: " + dayOfWeekIntegerMap.values());
    }
    static void showYoungMothersNamesWithHeavyBabies(List<Mother> mothers) {
        System.out.println("Imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.:");
        for (Mother mother : mothers) {
            System.out.println(mother.getFirstName());
        }
    }
    static void showGirlsInheritingMotherName(List<Child> children) {
        System.out.println("imiona i daty urodzenia dziewczynek, które odziedziczyły imię po matce: ");
        for (Child child : children) {
            System.out.println(child.getFirstName() + " " + child.getBirthDate());
        }
    }
    static void showMothersWithTwins(List<Mother> mothers) {
        for (Mother mother : mothers) {
            System.out.println(mother.getFirstName());
        }
    }


}
