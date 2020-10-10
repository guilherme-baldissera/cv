package com.bjs.cv.daos;

import com.bjs.cv.entities.CV;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CVRepository extends CrudRepository<CV, Integer>{
    List<CV> findAll();
}
