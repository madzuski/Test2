package pl.kurs.zadanie02.services;

import pl.kurs.zadanie02.datatypes.Doctor;
import pl.kurs.zadanie02.datatypes.Patient;
import pl.kurs.zadanie02.datatypes.Visit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VisitService {

    public static List<Visit> readVisitsFromFile(String path, Map<Integer, Doctor> doctors, Map<Integer, Patient> patients) {
        List<Visit> visits = new ArrayList<>();
        try (
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(new FileReader(path))
        ) {
            // Skip header
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                Visit visit = createVisitFromString(line, doctors, patients);
                if (visit != null) {
                    visits.add(visit);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading visits file: " + e.getMessage());
        }
        return visits;
    }

    private static Visit createVisitFromString(String line, Map<Integer, Doctor> doctors, Map<Integer, Patient> patients) {
        String[] parts = line.split("\\t");
        Doctor doctor = doctors.get(Integer.parseInt(parts[0]));
        Patient patient = patients.get(Integer.parseInt(parts[1]));
        LocalDate visitDate = LocalDate.parse(parts[2],  DateTimeFormatter.ofPattern("yyyy-M-d"));

        if (doctor != null && patient != null) {
            return  Visit.create(doctor, patient, visitDate);
        }
        return null;
    }
    //d) którego roku było najwięcej wizyt?
    public static int findYearWithMostVisits(List<Visit> visits) {
        Map<Integer, Integer> visitsByYear = new HashMap<>();
        for (Visit visit : visits) {
            int year = visit.getVisitDate().getYear();
            int currentCount = visitsByYear.getOrDefault(year, 0);
            visitsByYear.put(year, currentCount + 1);
        }
        int yearWithMostVisits = 0;
        int maxVisits = 0;
        
        for (Map.Entry<Integer, Integer> entry : visitsByYear.entrySet()) {
            if (entry.getValue() > maxVisits) {
                maxVisits = entry.getValue();
                yearWithMostVisits = entry.getKey();
            }
        }
        
        return yearWithMostVisits;
    }


} 