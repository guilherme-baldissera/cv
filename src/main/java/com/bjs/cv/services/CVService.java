package com.bjs.cv.services;

import com.bjs.cv.entities.CV;

import java.util.List;

public interface CVService {
    public CV addOrUpdateCV(CV cv);

    public void deleteCV(int id);

    public List<CV> getAllCVs();

    public CV getCVById(int id);
}
