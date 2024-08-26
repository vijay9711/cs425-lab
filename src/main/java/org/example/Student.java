package org.example;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class Student {
    private String studentId;
    private String name;
    private LocalDate dateOfAdmission;

    public Student() {
        this.studentId = "";
        this.name = "";
        this.dateOfAdmission = LocalDate.now();
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = LocalDate.now();
    }

    public Student(String studentId, String name, String dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = LocalDate.parse(dateOfAdmission, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public String getStudentId() {
        return studentId;
    }


    public String getName() {
        return name;
    }


    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", dateOfAdmission=" + dateOfAdmission +
                '}';
    }
}
