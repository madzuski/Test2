package pl.kurs.zadanie02.datatypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient {
    private int patientId;
    private String lastName;
    private String firstName;
    private String pesel;
    private LocalDate birthDate;
    private List<Visit> visits = new ArrayList<>();

    public Patient(int patientId, String lastName, String firstName, String pesel, LocalDate birthDate) {
        this.patientId = patientId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.pesel = pesel;
        this.birthDate = birthDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId && Objects.equals(lastName, patient.lastName) && Objects.equals(firstName, patient.firstName) && Objects.equals(pesel, patient.pesel) && Objects.equals(birthDate, patient.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, lastName, firstName, pesel, birthDate);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
} 