package pl.kurs.zadanie01.datatypes;

import java.time.LocalDate;
import java.util.List;

public class Child {

    private int newbornId;
    private Sex sex;
    private String firstName;
    private LocalDate birthDate;
    private int weight;
    private int height;
    private int motherId;
    private List<Mother> mother;

    public Child(int newbornId, Sex sex, String firstName, LocalDate birthDate, int weight, int height, int motherId) {
        this.newbornId = newbornId;
        this.sex = sex;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
        this.motherId = motherId;
    }

    public int getNewbornId() {
        return newbornId;
    }
    public Sex getSex() {
        return sex;
    }
    public String getFirstName() {
        return firstName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public int getWeight() {
        return weight;
    }
    public int getHeight() {
        return height;
    }
    public int getMotherId() {
        return motherId;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " +
                "newbornId=" + newbornId +
                ", sex='" + sex + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                ", height=" + height +
                ", motherId=" + motherId +
                '}';
    }

}
