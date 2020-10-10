package com.bjs.cv.entities;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class WorkExperience {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String companyName;
    @Getter
    @Setter
    private String jobDescription;
    @Getter
    @Setter
    private LocalDate startDay;
    @Getter
    @Setter
    private LocalDate endDay;


    public WorkExperience(String companyName, String jobDescription, LocalDate startDay, LocalDate endDay) {
        this.companyName = companyName;
        this.jobDescription = jobDescription;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public WorkExperience(){}

}
