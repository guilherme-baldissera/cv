package com.bjs.cv.daos;

import com.bjs.cv.entities.WorkExperience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository  extends CrudRepository<WorkExperience, Integer> {
}
