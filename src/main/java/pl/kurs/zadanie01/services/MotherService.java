package pl.kurs.zadanie01.services;

import pl.kurs.zadanie01.datatypes.Child;
import pl.kurs.zadanie01.datatypes.Mother;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MotherService {

    public static Map<Integer, Mother> readMothersFromFilePath(String path) {
        Map<Integer, Mother> mothersMap = new HashMap();
        try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Mother mothersFromString = createMotherFromString(line);
                mothersMap.put(mothersFromString.getMotherId(), mothersFromString);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return mothersMap;
    }

    private static Mother createMotherFromString(String line) {
        String[] array = line.split(" ");
        return new Mother(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]));
    }


    public static void assignChildrenToMothers(Collection<Mother> motherCollection, List<Child> childrenList) {
        for (Mother mother : motherCollection) {
            for (Child child : childrenList) {
                if (child.getMother().getMotherId() == mother.getMotherId()) {
                    mother.getChildren().add(child);
                }
            }
        }
    }

    //c) Podaj imiona kobiet w wieku poniżej 25 lat, które urodziły dzieci o wadze powyżej 4000 g.

    public static List<Mother> getYoungMothersWithHeavyBabiesList(List<Child> children) {
        List<Mother> youngMothers = new ArrayList<>();
        for (Child child : children) {
            Mother mother = child.getMother();
            if (child.getWeight() > 4000 && mother.getAge() < 25) {
                if (!youngMothers.contains(mother)) {
                    youngMothers.add(mother);
                }
            }
        }
        return youngMothers;
    }

    // e) Znajdz matki które urodziły bliźnięta.

    public static List<Mother> getMothersWithTwinsList(List<Child> children) {
        List<Mother> mothersWithTwins = new ArrayList<>();

        for (Child currentChild : children) {
            Mother mother = currentChild.getMother();

            if (mothersWithTwins.contains(mother)) {
                continue;
            }
            boolean hasTwins = children.stream()
                    .filter(sibling -> sibling.getMother().equals(mother))
                    .filter(sibling -> !sibling.equals(currentChild))
                    .anyMatch(sibling -> sibling.getBirthDate().equals(currentChild.getBirthDate()));

            if (hasTwins) {
                mothersWithTwins.add(mother);
            }
        }

        return mothersWithTwins;
    }
}
