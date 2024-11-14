package pl.kurs.zadanie01family.app;

import pl.kurs.zadanie01family.datatypes.Mother;
import pl.kurs.zadanie01family.services.FamilyDataProcessor;

import java.util.List;

public class FamilyAppRunner {
    public static void main(String[] args) {


        FamilyDataProcessor familyDataProcessor = new FamilyDataProcessor("mamy.txt", "noworodki.txt");

        String tallestChildren = familyDataProcessor.findTallestChildren();
        System.out.println(tallestChildren);
        System.out.println("-------------------------");
        String dayWithMostBirths = familyDataProcessor.dayWithMostBirths();
        System.out.println(dayWithMostBirths);
        System.out.println("-------------------------");
        List<String> youngMothersWithHeavyBabies = familyDataProcessor.findYoungMothersWithHeavyBabies();
        youngMothersWithHeavyBabies.forEach(System.out::println);
        System.out.println("-------------------------");
        List<String> girlsWithMothersName = familyDataProcessor.findGirlsWithMothersName();
        girlsWithMothersName.forEach(System.out::println);
        System.out.println("-------------------------");
//        List<Mother> mothersWithTwins = familyDataProcessor.findMothersWithTwins();
//        mothersWithTwins.forEach(System.out::println);

    }
}
