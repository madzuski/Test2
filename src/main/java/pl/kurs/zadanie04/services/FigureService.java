package pl.kurs.zadanie04.services;


import pl.kurs.zadanie04.datatypes.Figure;

import java.io.*;
import java.util.List;

public class FigureService {
    public static void saveToFile(List<Figure> figures, String filename) throws IOException {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))
        ) {
            oos.writeObject(figures);
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Figure> loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))
        ) {
            return (List<Figure>) ois.readObject();
        }
    }
}
