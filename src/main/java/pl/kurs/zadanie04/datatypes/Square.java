package pl.kurs.zadanie04.datatypes;

public class Square extends Figure {

    private double side;

    public Square(double side) {
        super(false);
        this.side = side;
    }

    protected Square(double side, boolean useFactory) {
        super(useFactory);
        this.side = side;
    }

    @Override
    public double getCircumference() {
        return 4 * side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public boolean contains(Figure other) {
        if (other instanceof Square) {
            return ((Square) other).side == this.side;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Figure #%d: A square with side %.1f.", number, side);
    }
}
