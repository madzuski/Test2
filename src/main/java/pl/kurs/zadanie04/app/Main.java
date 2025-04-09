package pl.kurs.zadanie04.app;

import pl.kurs.zadanie04.datatypes.*;
import pl.kurs.zadanie04.services.FigureService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = Arrays.asList(
                Figure.createSquare(10),
                Figure.createCircle(10),
                Figure.createRectangle(10, 20)
        );

        // Print all figures
        for (Figure f : figures) {
            System.out.println(f);
        }

        // Find figure with largest circumference
        Figure largestCircumference = figures.stream()
                .max(Comparator.comparingDouble(Figure::getCircumference))
                .orElse(null);
        System.out.println("Largest circumference: " + largestCircumference);

        // Find figure with largest area
        Figure largestArea = figures.stream()
                .max(Comparator.comparingDouble(Figure::getArea))
                .orElse(null);
        System.out.println("Largest area: " + largestArea);

        // Test contains method
        System.out.println(figures.contains(new Square(10))); // true

        // Save to file
        //Saves data in binary format (not human-readable)
        try {
            FigureService.saveToFile(figures, "figures.dat");
            List<Figure> loadedFigures = FigureService.loadFromFile("figures.dat");
            System.out.println("Loaded figures: " + loadedFigures);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}