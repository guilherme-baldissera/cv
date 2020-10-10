package com.bjs.cv.services;

import com.bjs.cv.entities.CV;
import com.bjs.cv.entities.Skill;

public interface SkillService {

    public CV add(Skill skill, int userId);

    public Skill update(Skill skill, int userId);

    public Skill getById(int id);

    public void deleteById(int id);
}
