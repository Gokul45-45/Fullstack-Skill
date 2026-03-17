package com.klu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    // Constructor Injection (Annotation-based)
    public Student(
            @Value("102") int studentId,
            @Value("Ananya") String name,
            @Value("AI & DS") String course,
            @Value("2") int year) {

        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // Getter & Setter methods (Setter Injection)
    public int getStudentId() {
        return studentId;
    }

    @Value("Full Stack Development")
    public void setCourse(String course) {
        this.course = course;
    }

    @Value("3")
    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Course     : " + course);
        System.out.println("Year       : " + year);
    }
}
