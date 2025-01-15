package pl.kurs.zadanie04.datatypes;

public class Circle extends Figure {

    private double radius;

    public Circle(double radius) {
        super(false);
        this.radius = radius;
    }

    protected Circle(double radius, boolean useFactory) {
        super(useFactory);
        this.radius = radius;
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public boolean contains(Figure other) {
        if (other instanceof Circle) {
            return ((Circle) other).radius == this.radius;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Figure #%d: A circle with a radius of %.1f.", number, radius);
    }
}
