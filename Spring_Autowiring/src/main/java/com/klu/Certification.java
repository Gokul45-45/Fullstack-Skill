package com.klu;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id;
    private String name;
    private String dateOfCompletion;

    public Certification() {
        this.id = 501;
        this.name = "Java Full Stack";
        this.dateOfCompletion = "15-Jan-2026";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfCompletion() {
        return dateOfCompletion;
    }

    @Override
    public String toString() {
        return "Certification ID : " + id +
               "\nCertification Name : " + name +
               "\nDate of Completion : " + dateOfCompletion;
    }
}
