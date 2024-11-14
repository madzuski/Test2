package pl.kurs.zadanie03.datatypes;

import java.io.Serializable;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String pesel;
    private String city;

    public Person(String firstName, String lastName, String pesel, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getCity() {
        return city;
    }

    public double getIncome() {
        return 0;
    }

    public String getDepartment() {
        return null;
    }

    public  Sex getSex() {
        int sexIndicator = Integer.parseInt(String.valueOf(pesel.charAt(9)));
        return (sexIndicator % 2 == 0) ? Sex.FEMALE : Sex.MALE;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", city='" + city + '\'' +
                '}';
    }

}
