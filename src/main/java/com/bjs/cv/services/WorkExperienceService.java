package com.bjs.cv.services;

import com.bjs.cv.entities.CV;
import com.bjs.cv.entities.WorkExperience;

public interface WorkExperienceService {

    public CV add(WorkExperience workExperience, int cvId);

    public WorkExperience update(WorkExperience workExperience, int id);

    public WorkExperience getById(int id);

    public void deleteById(int id);
}
