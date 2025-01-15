package pl.kurs.zadanie04.datatypes;

import java.io.Serializable;

public abstract class Figure implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int counter = 0;
    protected int number;

    protected Figure() {
        this.number = 0;
    }

    protected Figure(boolean useFactory) {
        this.number = useFactory ? ++counter : 0;
    }

    public abstract double getCircumference();
    public abstract double getArea();
    public abstract boolean contains(Figure other);

    // Factory methods
    public static Square createSquare(double side) {
        return new Square(side, true);
    }

    public static Circle createCircle(double radius) {
        return new Circle(radius, true);
    }

    public static Rectangle createRectangle(double width, double height) {
        return new Rectangle(width, height, true);
    }
}
