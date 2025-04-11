package pl.kurs.zadanie03_v2.datatypes;


public abstract class Person {
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

    public String getPlec() {
        // Assuming the 10th digit of PESEL determines gender: odd(nieparzyste) for male, even(parzyste) for female
        int genderDigit = Character.getNumericValue(pesel.charAt(9));
        return (genderDigit % 2 == 0) ? "Female" : "Male";
    }

    public abstract double getIncome();

    public abstract String getPersonAssignment();

    public abstract String getType();

    public String toCSV() {
        return getType() + ";" +
                firstName + ";" +
                lastName + ";" +
                pesel + ";" +
                city + ";" +
                getPersonAssignment() + ";" +
                getIncome();
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

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", city='" + city + '\'';
    }

}
