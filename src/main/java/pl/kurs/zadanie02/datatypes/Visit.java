package pl.kurs.zadanie02.datatypes;

import java.time.LocalDate;
import java.util.Objects;

public class Visit {
    private Doctor doctor;
    private Patient patient;
    private LocalDate visitDate;

    private Visit(Doctor doctor, Patient patient, LocalDate visitDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.visitDate = visitDate;

    }

    public static Visit create(Doctor doctor, Patient patient, LocalDate visitDate) {
        Visit visit = new Visit(doctor, patient,visitDate);
        doctor.getVisits().add(visit);
        patient.getVisits().add(visit);
        return visit;
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(doctor, visit.doctor) && Objects.equals(patient, visit.patient) && Objects.equals(visitDate, visit.visitDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctor, patient, visitDate);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "doctor=" + doctor.getLastName() +
                ", patient=" + patient.getLastName() +
                ", visitDate=" + visitDate +
                '}';
    }
} 