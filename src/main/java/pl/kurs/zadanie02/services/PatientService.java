package pl.kurs.zadanie02.services;

import pl.kurs.zadanie02.datatypes.Doctor;
import pl.kurs.zadanie02.datatypes.Patient;
import pl.kurs.zadanie02.datatypes.Visit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PatientService {

    public static Map<Integer, Patient> readPatientsFromFile(String path) {
        Map<Integer, Patient> patientsMap = new HashMap<>();
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Patient patient = createPatientFromString(line);
                patientsMap.put(patient.getPatientId(), patient);
            }
        } catch (IOException e) {
            System.err.println("Error reading patients file: " + e.getMessage());
        }
        return patientsMap;
    }

    private static Patient createPatientFromString(String line) {
        String[] parts = line.split("\\t");
        return new Patient(
                Integer.parseInt(parts[0]),  // patientId
                parts[1],                    // lastName
                parts[2],                    // firstName
                parts[3],                    // pesel
                LocalDate.parse(parts[4], DateTimeFormatter.ofPattern("yyyy-M-d")) // birthDate
        );
    }
    //b) znajdź pacjenta który miał najwięcej wizyt
    public static Patient findPatientWithMostVisits(Map<Integer, Patient> patients) {
        Patient patientWithMostVisits = null;
        int maxVisits = 0;
        
        for (Patient patient : patients.values()) {
            int visitsCount = patient.getVisits().size();
            if (visitsCount > maxVisits) {
                maxVisits = visitsCount;
                patientWithMostVisits = patient;
            }
        }
        return patientWithMostVisits;
    }

    //g) zwróć pacjentów którzy byli u minimum 5 różnych lekarzy
    public static List<Patient> findPatientsWithMultipleDoctors(Map<Integer, Patient> patients, int minDoctors) {
        List<Patient> patientsWithMultipleDoctors = new ArrayList<>();
        
        for (Patient patient : patients.values()) {
            Set<Doctor> uniqueDoctors = new HashSet<>();
            for (Visit visit : patient.getVisits()) {
                uniqueDoctors.add(visit.getDoctor());
            }
            
            if (uniqueDoctors.size() >= minDoctors) {
                patientsWithMultipleDoctors.add(patient);
            }
        }
        
        return patientsWithMultipleDoctors;
    }
} 