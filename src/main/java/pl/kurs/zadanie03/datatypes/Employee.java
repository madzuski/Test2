package pl.kurs.zadanie03.datatypes;


public class Employee extends Person {
    private String position;
    private double salary;

    public Employee(String firstName, String lastName, String pesel, String city, String position, double salary) {
        super(firstName, lastName, pesel, city);
        this.position = position;
        this.salary = salary;
    }

    public double getIncome() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

}