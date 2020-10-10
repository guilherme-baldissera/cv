package com.bjs.cv.entities;

import com.bjs.cv.enums.Level;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Skill {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String skillName;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private Level level;

    public Skill(String skillName, Level level) {
        this.skillName = skillName;
        this.level = level;
    }

    public Skill(){

    }
}
