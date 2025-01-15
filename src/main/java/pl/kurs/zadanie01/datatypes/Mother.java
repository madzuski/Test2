package pl.kurs.zadanie01.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mother {

    private int motherId;
    private String firstName;
    private int age;
    private List<Child> children = new ArrayList<>();


    public Mother(int motherId, String firstName, int age) {
        this.motherId = motherId;
        this.firstName = firstName;
        this.age = age;
    }

    public int getMotherId() {
        return motherId;
    }

    public List<Child> getChildren() {
        return children;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mother mother = (Mother) o;
        return motherId == mother.motherId && age == mother.age && Objects.equals(firstName, mother.firstName) && Objects.equals(children, mother.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motherId, firstName, age, children);
    }

    @Override
    public String toString() {
        return "Mother{" +
                "motherId=" + motherId +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
