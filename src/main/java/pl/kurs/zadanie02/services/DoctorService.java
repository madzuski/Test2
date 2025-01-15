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
import java.util.stream.Collectors;

public class DoctorService {

    public static Map<Integer, Doctor> readDoctorsFromFile(String path) {
        Map<Integer, Doctor> doctorsMap = new HashMap<>();
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr)
        ) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Doctor doctor = createDoctorFromString(line);
                doctorsMap.put(doctor.getDoctorId(), doctor);
            }
        } catch (IOException e) {
            System.err.println("Error reading doctors file: " + e.getMessage());
        }
        return doctorsMap;
    }

    private static Doctor createDoctorFromString(String line) {
        String[] parts = line.split("\\t");
        return new Doctor(
                Integer.parseInt(parts[0]),
                parts[1],//nazwisko
                parts[2],//imie
                parts[3],//specjalnosc
                LocalDate.parse(parts[4], DateTimeFormatter.ofPattern("yyyy-MM-dd")), // data_uodzenia
                parts[4],//nip
                parts[5]//pesel
        );
    }

    //a) znajdź lekarza ktory miał najwięcej wizyt
    public static Doctor findDoctorWithMostVisits(Map<Integer, Doctor> doctors) {
        Doctor doctorWithMostVisits = null;
        int maxVisits = 0;

        for (Doctor doctor : doctors.values()) {
            int visitsCount = doctor.getVisits().size();
            if (visitsCount > maxVisits) {
                maxVisits = visitsCount;
                doctorWithMostVisits = doctor;
            }
        }
        return doctorWithMostVisits;
    }

    //c) która specalizacja cieszy się największym powodzeniem?
    public static String findMostPopularSpecialty(Map<Integer, Doctor> doctors) {

        Map<String, Integer> specialtyVisitCount = new HashMap<>();
        for (Doctor doctor : doctors.values()) {
            String specialty = doctor.getSpecialty();
            int currentVisits = specialtyVisitCount.getOrDefault(specialty, 0);
            specialtyVisitCount.put(specialty, currentVisits + doctor.getVisits().size());
        }

        String mostPopularSpecialty = null;
        int maxVisits = 0;

        for (Map.Entry<String, Integer> entry : specialtyVisitCount.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
                mostPopularSpecialty = entry.getKey();
            }
        }

        return mostPopularSpecialty;
    }

    //e) wypisz top 5 najstarszych lekarzy
    public static List<Doctor> findTopOldestDoctors(Map<Integer, Doctor> doctors, int limit) {
        List<Doctor> allDoctors = new ArrayList<>(doctors.values());

        Collections.sort(allDoctors, Comparator.comparing(Doctor::getBirthDate));

        return allDoctors.subList(0, Math.min(limit, allDoctors.size()));
    }

    //f) wypisz top 5 lekarzy którzy mieli najwięcej wizyt
    public static List<Doctor> findTopDoctorsWithMostVisits(Map<Integer, Doctor> doctors, int limit) {
        List<Doctor> allDoctors = new ArrayList<>(doctors.values());

        Collections.sort(allDoctors, (d1, d2) -> Integer.compare(d2.getVisits().size(), d1.getVisits().size()));

        return allDoctors.subList(0, Math.min(limit, allDoctors.size()));
    }

    //h) zwróć lekarzy którzy przyjmowali tylko jednego pacjenta
    public static List<Doctor> findDoctorsWithSinglePatient(Map<Integer, Doctor> doctors) {
        List<Doctor> doctorsWithSinglePatient = new ArrayList<>();

        for (Doctor doctor : doctors.values()) {
            Set<Patient> uniquePatients = doctor.getVisits().stream()
                    .map(Visit::getPatient)
                    .collect(Collectors.toSet());

            if (uniquePatients.size() == 1 && !doctor.getVisits().isEmpty()) {
                doctorsWithSinglePatient.add(doctor);
            }
        }
        return doctorsWithSinglePatient;
    }
} 