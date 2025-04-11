package pl.kurs.zadanie03_v2.datatypes;


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

    @Override
    public String getPersonAssignment() {
        return group;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }

    @Override
    public String toString() {
        return super.toString() +
                " group='" + group + '\'' +
                ", scholarship=" + scholarship +
                '}';
    }

}
