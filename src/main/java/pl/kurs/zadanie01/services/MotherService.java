package pl.kurs.zadanie01.services;

import pl.kurs.zadanie01.datatypes.Mother;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MotherService {

    public static List<Mother> readMothersFromFilePath(String path) {
        List<Mother> mothers = new ArrayList<>();
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Mother mothersFromString = createMotherFromString(line);
                mothers.add(mothersFromString);
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
}
