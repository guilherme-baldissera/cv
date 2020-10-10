package com.bjs.cv.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class CV {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    @Embedded
    @Column(nullable = false)
    private UserInfo userInfo;
    @Getter
    @Setter
    @ElementCollection
    private List<Education> educations;
    @Getter
    @Setter
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Skill> skills;
    @Getter
    @Setter
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<WorkExperience> workExperiences;

    public CV() {
    }

    public CV( UserInfo userInfo, List<Education> educations, List<Skill> skills, List<WorkExperience> workExperiences) {
        this.userInfo = userInfo;
        this.educations = educations;
        this.skills = skills;
        this.workExperiences = workExperiences;
    }
}
