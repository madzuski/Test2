package pl.kurs.zadanie04.datatypes;

public class Circle extends Figure implements Shape {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * PI_NUMBER * r;
    }

    @Override
    public double calculateArea() {
        return PI_NUMBER * r * r;
    }


}
