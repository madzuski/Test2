package pl.kurs.zadanie03.app;

import pl.kurs.zadanie03.datatypes.Employee;
import pl.kurs.zadanie03.datatypes.Person;
import pl.kurs.zadanie03.datatypes.Student;
import pl.kurs.zadanie03.services.SchoolService;

public class SchoolRunner {
    public static void main(String[] args) {

        SchoolService schoolService = new SchoolService();
        Person[] people = new Person[5];
        people[0] = new Student("Jakub", "Majewski", "97091905952", "Kielce", "14A",1200.70);
        people[1] = new Student("Anna", "Nowak", "65071209862", "Warsaw", "10B", 1300.50);
        people[2] = new Student("Marta", "Wiśniewska", "90060804786", "Gdansk", "12C", 1400.80);
        people[3] = new Employee("Paweł", "Kominek","81100216357","Kielce", "Nauczyciel_js", 3_000);
        people[4] = new Employee("Karolina", "Kowalska", "80072909146", "Krakow", "Nauczyciel_cpp", 4_500);

        Person personWithHighestIncome = schoolService.findPersonWithHighestIncome(people);
        System.out.println("personWithHighestIncome = " + personWithHighestIncome);

        int females = schoolService.countFemales(people);
        System.out.println("females = " + females);

        schoolService.saveToFile(people,"peopleToTxt");


        Person person1 = new Student("Jakub", "Majewski", "97091905952", "Kielce", "14A",1200.70);
        Student studentHelper = (Student) person1;



    }

}
