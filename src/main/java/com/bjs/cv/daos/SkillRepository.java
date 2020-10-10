package com.bjs.cv.daos;

import com.bjs.cv.entities.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
