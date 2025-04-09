package pl.kurs.zadanie04.datatypes;

import java.util.Objects;

public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super(false);
        this.width = width;
        this.height = height;
    }

    protected Rectangle(double width, double height, boolean useFactory) {
        super(useFactory);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getCircumference() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public boolean contains(Figure other) {
        if (other instanceof Rectangle) {
            Rectangle r = (Rectangle) other;
            return r.width == this.width && r.height == this.height;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Figure #%d: A rectangle with sides %.1fx%.1f.", number, width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(height, rectangle.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
