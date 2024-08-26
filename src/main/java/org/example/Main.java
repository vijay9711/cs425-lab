package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create an array of Students
        Student[] students = new Student[]{
                new Student("110001", "Dave", "11/18/1951"),
                new Student("110002", "Anna", "12/07/1990"),
                new Student("110003", "Erica", "01/31/1974"),
                new Student("110004", "Carlos", "08/22/2009"),
                new Student("110005", "Bob", "03/05/1990")
        };

        // Call the printListOfStudents method
        printListOfStudents(students);

        // Call the getListOfPlatinumAlumniStudents method
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        System.out.println("Platinum Alumni Students:");
        platinumAlumni.forEach(System.out::println);
    }

    // Method to print list of students sorted by name
    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("List of Students in Ascending Order of Names:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Method to get list of Platinum Alumni Students
    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumni = new ArrayList<>();
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);
        for (Student student : students) {
            if (student.getDateOfAdmission().isBefore(thirtyYearsAgo)) {
                platinumAlumni.add(student);
            }
        }
        platinumAlumni.sort(Comparator.comparing(Student::getDateOfAdmission).reversed());
        return platinumAlumni;
    }
}