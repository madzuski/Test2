package pl.kurs.zadanie03_v2.datatypes;


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

    @Override
    public String getPersonAssignment() {
        return position;
    }

    @Override
    public String getType() {
        return "EMPLOYEE";
    }

    @Override
    public String toString() {
        return super.toString() +
                " position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}