package pl.kurs.zadanie02.datatypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor {
    private int doctorId;
    private String lastName;
    private String firstName;
    private String specialty;
    private LocalDate birthDate;
    private String taxId;
    private String pesel;
    private List<Visit> visits = new ArrayList<>();

    public Doctor(int doctorId, String lastName, String firstName, String specialty,
                  LocalDate birthDate, String taxId, String pesel) {
        this.doctorId = doctorId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.specialty = specialty;
        this.birthDate = birthDate;
        this.taxId = taxId;
        this.pesel = pesel;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getPesel() {
        return pesel;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return doctorId == doctor.doctorId && Objects.equals(lastName, doctor.lastName) && Objects.equals(firstName, doctor.firstName) && Objects.equals(specialty, doctor.specialty) && Objects.equals(birthDate, doctor.birthDate) && Objects.equals(taxId, doctor.taxId) && Objects.equals(pesel, doctor.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, lastName, firstName, specialty, birthDate, taxId, pesel);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", birthDate=" + birthDate +
                ", taxId='" + taxId + '\'' +
                ", pesel='" + pesel + '\'' +
                '}';
    }
} 