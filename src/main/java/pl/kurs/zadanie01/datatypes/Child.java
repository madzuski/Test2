package pl.kurs.zadanie01.datatypes;

import java.time.LocalDate;
import java.util.Objects;

public class Child {

    private int newbornId;
    private Sex sex;
    private String firstName;
    private LocalDate birthDate;
    private int weight;
    private int height;
    private Mother mother;

    public Child(int newbornId, Sex sex, String firstName, LocalDate birthDate, int weight, int height, Mother mother) {
        this.newbornId = newbornId;
        this.sex = sex;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
        this.mother = mother;
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

    public Mother getMother() {
        return mother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Child child = (Child) o;
        return newbornId == child.newbornId && weight == child.weight && height == child.height && sex == child.sex && Objects.equals(firstName, child.firstName) && Objects.equals(birthDate, child.birthDate) && Objects.equals(mother, child.mother);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newbornId, sex, firstName, birthDate, weight, height, mother);
    }

    @Override
    public String toString() {
        return "Child{" +
                "newbornId=" + newbornId +
                ", sex=" + sex +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                ", height=" + height +
                ", mother=" + mother +
                '}';
    }
}
