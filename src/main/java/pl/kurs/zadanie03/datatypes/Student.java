package pl.kurs.zadanie03.datatypes;


public class Student extends Person {
    private String group;
    private double scholarship;

    public Student(String firstName, String lastName, String pesel, String city, String group, double scholarship) {
        super(firstName, lastName, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    public double getIncome() {
        return scholarship;
    }

    public String getGroup() {
        return group;
    }

    public double getScholarship() {
        return scholarship;
    }

}
