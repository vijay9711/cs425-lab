package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("110001", "Dave", "11/18/1951"),
                new Student("110002", "Anna", "12/07/1990"),
                new Student("110003", "Erica", "01/31/1974"),
                new Student("110004", "Carlos", "08/22/2009"),
                new Student("110005", "Bob", "03/05/1990")
        };

        printListOfStudents(students);

        int[] numbers = {5, 7, 35, 10};
        printHelloWorld(numbers);
        findSecondBiggest(numbers);
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        System.out.println("Platinum Alumni Students:");
        platinumAlumni.forEach(System.out::println);
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("List of Students in Ascending Order of Names:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

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

    public static void printHelloWorld(int[] numbers) {
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (number % 5 == 0) {
                System.out.println("Hello");
            } else if (number % 7 == 0) {
                System.out.println("World");
            }
        }
    }
    public static int findSecondBiggest(int[] numbers) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > first) {
                second = first;
                first = number;
            } else if (number > second && number < first) {
                second = number;
            }
        }
        return second;
    }
}
