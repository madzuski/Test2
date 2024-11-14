package pl.kurs.zadanie04.datatypes;

public class Square extends Figure implements Shape {

    private double a;


    public Square(double a) {
        this.a = a;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * a;
    }

    @Override
    public double calculateArea() {
        return a * a;
    }
}
