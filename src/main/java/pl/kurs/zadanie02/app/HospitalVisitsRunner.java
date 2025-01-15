package pl.kurs.zadanie02.app;

import pl.kurs.zadanie02.datatypes.Doctor;
import pl.kurs.zadanie02.datatypes.Patient;
import pl.kurs.zadanie02.datatypes.Visit;
import pl.kurs.zadanie02.services.DoctorService;
import pl.kurs.zadanie02.services.PatientService;
import pl.kurs.zadanie02.services.VisitService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HospitalVisitsRunner {
    public static void main(String[] args) {

        Map<Integer, Doctor> doctorsMap = DoctorService.readDoctorsFromFile("lekarze.txt");
        Map<Integer, Patient> patientsMap = PatientService.readPatientsFromFile("pacjenci.txt");
        List<Visit> visits = VisitService.readVisitsFromFile("wizyty.txt", doctorsMap, patientsMap);

        List<Patient> patientList = new ArrayList<>(patientsMap.values());

        // a) Find doctor with most visits
        Doctor doctorWithMostVisits = DoctorService.findDoctorWithMostVisits(doctorsMap);
        showDoctorsWithMostVisits(doctorWithMostVisits);
        System.out.println("-------------------------");
        // b) Find patient with most visits
        Patient patientWithMostVisits = PatientService.findPatientWithMostVisits(patientsMap);
        showPatientWithMostVisits(patientWithMostVisits);
        System.out.println("-------------------------");
        // c) Find most popular specialty
        String mostPopularSpecialty = DoctorService.findMostPopularSpecialty(doctorsMap);
        showMostPopularSpecialty(mostPopularSpecialty);
        System.out.println("-------------------------");
        // d) Find year with most visits
        int yearWithMostVisits = VisitService.findYearWithMostVisits(visits);
        showYearWithMostVisits(yearWithMostVisits);
        System.out.println("-------------------------");
        // e) Find top 5 oldest doctors
        List<Doctor> oldestDoctors = DoctorService.findTopOldestDoctors(doctorsMap, 5);
        showOldestDoctors(oldestDoctors);
        System.out.println("-------------------------");
        // f) Find top 5 doctors with most visits
        List<Doctor> topDoctors = DoctorService.findTopDoctorsWithMostVisits(doctorsMap, 5);
        showTopDoctorsWithMostVisits(topDoctors);
        System.out.println("-------------------------");
        // g) Find patients who visited at least 5 different doctors
        List<Patient> patientsWithMultipleDoctors = PatientService.findPatientsWithMultipleDoctors(patientsMap, 5);
        showPatientsWithMultipleDoctors(patientsWithMultipleDoctors);
        System.out.println("-------------------------");
        // h) Find doctors who had only one patient
        List<Doctor> doctorsWithSinglePatient = DoctorService.findDoctorsWithSinglePatient(doctorsMap);
        showDoctorsWithSinglePatient(doctorsWithSinglePatient);
    }

    static void showDoctorsWithMostVisits(Doctor doctor) {
        System.out.println("Doctor with most visits: " +
                doctor.getFirstName() + " " +
                doctor.getLastName() +
                " (specialty: " + doctor.getSpecialty() + ")" +
                " - number of visits: " + doctor.getVisits().size());
    }

    static void showPatientWithMostVisits(Patient patient) {
        System.out.println("Patient with most visits: " +
                patient.getFirstName() + " " +
                patient.getLastName() +
                " - number of visits: " + patient.getVisits().size());
    }

    static void showMostPopularSpecialty(String specialty) {
        System.out.println("Most popular specialty: " + specialty);
    }

    static void showYearWithMostVisits(int year) {
        System.out.println("Year with most visits: " + year);
    }

    static void showOldestDoctors(List<Doctor> doctors) {
        System.out.println("Top 5 oldest doctors:");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getFirstName() + " " + 
                doctor.getLastName() + " (born: " + doctor.getBirthDate() + ")");
        }
    }

    static void showTopDoctorsWithMostVisits(List<Doctor> doctors) {
        System.out.println("Top 5 doctors with most visits:");
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            System.out.println((i + 1) + ". " + doctor.getFirstName() + " " + 
                doctor.getLastName() + " (specialty: " + doctor.getSpecialty() + ")" +
                " - visits: " + doctor.getVisits().size());
        }
    }

    static void showPatientsWithMultipleDoctors(List<Patient> patients) {
        System.out.println("Patients who visited at least 5 different doctors:");
        if (patients.isEmpty()) {
            System.out.println("No patients found who visited 5 or more different doctors");
        } else {
            for (int i = 0; i < patients.size(); i++) {
                Patient patient = patients.get(i);
                Set<Doctor> uniqueDoctors = patient.getVisits().stream()
                    .map(Visit::getDoctor)
                    .collect(Collectors.toSet());
                    
                System.out.println((i + 1) + ". " + patient.getFirstName() + " " + 
                    patient.getLastName() + " (visited " + uniqueDoctors.size() + 
                    " different doctors)");
            }
        }
    }

    static void showDoctorsWithSinglePatient(List<Doctor> doctors) {
        System.out.println("Doctors who had only one patient:");
        if (doctors.isEmpty()) {
            System.out.println("No doctors found who had only one patient");
        } else {
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doctor = doctors.get(i);
                Patient onlyPatient = doctor.getVisits().get(0).getPatient();
                System.out.println((i + 1) + ". " + doctor.getFirstName() + " " + 
                    doctor.getLastName() + " (specialty: " + doctor.getSpecialty() + ")" +
                    " - patient: " + onlyPatient.getFirstName() + " " + onlyPatient.getLastName() +
                    " (visits count: " + doctor.getVisits().size() + ")");
            }
        }
    }
} 