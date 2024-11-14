package pl.kurs.zadanie01family.services;

import pl.kurs.zadanie01family.datatypes.Child;
import pl.kurs.zadanie01family.datatypes.Mother;
import pl.kurs.zadanie01family.datatypes.Sex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyDataProcessor {

    private List<Mother> mothers;
    private List<Child> children;

    public FamilyDataProcessor(String momsFile, String newbornsFile) {
        mothers = loadMothers(momsFile);
        children = loadChildren(newbornsFile);

    }

    public List<Mother> loadMothers(String filename) {
        List<Mother> mothers = new ArrayList<>();
        try (
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Mother motherFromString = createMotherFromString(line);
                mothers.add(motherFromString);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return mothers;
    }

    private static Mother createMotherFromString(String line) {
        String[] array = line.split(" ");
        return new Mother(
                Integer.parseInt(array[0]),
                array[1],
                Integer.parseInt(array[2]));
    }


    public List<Child> loadChildren(String filename) {
        List<Child> children = new ArrayList<>();
        try (
                FileReader fr = new FileReader(filename);
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                Child childFromString = createChildFromString(line);
                children.add(childFromString);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return children;
    }

    private Child createChildFromString(String line) {
        String[] array = line.split(" ");
        Sex[] sexValues = Sex.values();
        int id = Integer.parseInt(array[0]);
        String name = array[2];
        LocalDate birthDate = LocalDate.parse(array[3], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int weight = Integer.parseInt(array[4]);
        int height = Integer.parseInt(array[5]);
        int motherId = Integer.parseInt(array[6]);

        Mother mother = findMotherById(motherId);
        if (mother != null) {
            Child child = new Child(id, sexValues[chooseSex(array[1])], name, birthDate, weight, height, mother);
            mother.addChild(child);
            mother.addChild(child);
        }
        return new Child(id, sexValues[chooseSex(array[1])], name, birthDate, weight, height, mother);
    }

    public int chooseSex(String sex) {
        if (sex.equals("c")) {
            return 0;
        } else {
            return 1;
        }
    }

    public Mother findMotherById(int id) {
        for (Mother mother : mothers) {
            if (mother.getId() == id) {
                return mother;
            }
        }
        return null;
    }

    // Task (a) - Tallest boy and girl
    public String findTallestChildren() {
        Child tallestBoy = null;
        Child tallestGirl = null;

        for (Child child : children) {
            if (child.getSex().equals(Sex.MALE) && (tallestBoy == null || child.getHeight() > tallestBoy.getHeight())) {
                tallestBoy = child;
            } else if (child.getSex().equals(Sex.FEMALE) && (tallestGirl == null || child.getHeight() > tallestGirl.getHeight())) {
                tallestGirl = child;
            }
        }

        return "Tallest Boy: " + (tallestBoy != null ? tallestBoy.getName() + ", Height: " + tallestBoy.getHeight() : "None") +
                "\nTallest Girl: " + (tallestGirl != null ? tallestGirl.getName() + ", Height: " + tallestGirl.getHeight() : "None");
    }

    // Task (b) - Day with most births
    public String dayWithMostBirths() {
        int[] birthDays = new int[7];
        for (Child child : children) {
            DayOfWeek dayOfWeek = child.getBirthDate().getDayOfWeek();
            birthDays[dayOfWeek.getValue() - 1]++;
        }

        int maxCount = 0;
        DayOfWeek mostCommonDay = null;
        for (int i = 0; i < birthDays.length; i++) {
            if (birthDays[i] > maxCount) {
                maxCount = birthDays[i];
                mostCommonDay = DayOfWeek.of(i + 1);
            }
        }
        return "Day with most births: " + mostCommonDay + " with " + maxCount + " births";
    }

    // Task (c) - Young mothers with heavy babies
    public List<String> findYoungMothersWithHeavyBabies() {
        Set<String> uniqueResults = new HashSet<>();
        for (Mother mother : mothers) {
            if (mother.getAge() < 25) {
                for (Child child : mother.getChildren()) {
                    if (child.getWeight() > 4000) {
                        uniqueResults.add(mother.getName() + " (Child: " + child.getName() + ")");
                    }
                }
            }
        }
        return new ArrayList<>(uniqueResults); // Convert the Set back to a List before returning
    }

    // Task (d) - Girls who inherited mother's name
    public List<String> findGirlsWithMothersName() {
        List<String> result = new ArrayList<>();
        for (Child child : children) {
            if (child.getSex().equals(Sex.FEMALE) && child.getName().equals(child.getMother().getName())) {
                result.add(child.getName() + " (" + child.getBirthDate() + ")");
            }
        }
        return result;
    }

    //     Task (e) - Mothers with twins StackOverflowError!
//    public List<Mother> findMothersWithTwins() {
//        List<Mother> mothersWithTwins = new ArrayList<>();
//
//        for (Mother mother : mothers) {
//            if (mother.getChildren().size() > 1) {
//                Set<LocalDate> birthDates = new HashSet<>();
//                boolean hasTwins = false;
//
//                for (Child child : mother.getChildren()) {
//                    if (!birthDates.add(child.getBirthDate())) {
//                        hasTwins = true;
//                        break; // Stop checking if twins are found
//                    }
//                }
//
//                if (hasTwins) {
//                    mothersWithTwins.add(mother);
//                }
//            }
//        }
//
//        return mothersWithTwins;
//    }



}
