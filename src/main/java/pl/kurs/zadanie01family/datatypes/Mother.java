package pl.kurs.zadanie01family.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Mother {
    int id;
    String name;
    int age;
    List<Child> children = new ArrayList<>();

    public Mother(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public List<Child> getChildren() {
        return children;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addChild(Child child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Mother{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", children=" + children +
                '}';
    }
}
