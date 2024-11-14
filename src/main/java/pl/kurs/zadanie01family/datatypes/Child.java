package pl.kurs.zadanie01family.datatypes;

import java.time.LocalDate;

public class Child {
    int id;
    Sex sex;
    String name;
    LocalDate birthDate;
    int weight;
    int height;
    Mother mother;

    public Child(int id, Sex sex, String name, LocalDate birthDate, int weight, int height, Mother mother) {
        this.id = id;
        this.sex = sex;
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        this.height = height;
        this.mother = mother;
    }

    public int getId() {
        return id;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
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
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                ", height=" + height +
                ", mother=" + mother +
                '}';
    }
}

