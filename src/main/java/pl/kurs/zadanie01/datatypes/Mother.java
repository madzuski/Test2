package pl.kurs.zadanie01.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Mother {

    private int motherId;
    private String firstName;
    private int age;
    private List<Child> children = new ArrayList<>();


    public Mother(int motherId, String name, int age) {
        this.motherId = motherId;
        this.firstName = name;
        this.age = age;
    }
    public int getMotherId() {
        return motherId;
    }
    public int getAge() {
        return age;
    }
    public String getFirstName() {
        return firstName;
    }

    public List<Child> getChildren() {
        return children;
    }

    void addChild(Child child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - " +
                "motherId=" + motherId +
                ", name='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}
