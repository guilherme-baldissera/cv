package com.bjs.cv.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
public class Education {
    @Getter
    @Setter
    private String institutionName;
    @Getter
    @Setter
    private String courseName;
    @Getter
    @Setter
    private String degreeLevel;

    public Education(String institutionName, String courseName, String degreeLevel) {
        this.institutionName = institutionName;
        this.courseName = courseName;
        this.degreeLevel = degreeLevel;
    }

    public Education(){}
}
