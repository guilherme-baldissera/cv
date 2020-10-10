package com.bjs.cv.services;

import com.bjs.cv.daos.CVRepository;
import com.bjs.cv.entities.CV;
import com.bjs.cv.exceptions.IDNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CVServiceImp implements CVService {

    private CVRepository cvRepository;

    public CVServiceImp(CVRepository cvRepository){
        this.cvRepository = cvRepository;
    }

    public CV addOrUpdateCV(CV cv){
        return cvRepository.save(cv);
    }

    public void deleteCV(int id){
        this.getCVById(id);
        cvRepository.deleteById(id);
    }

    public List<CV> getAllCVs(){
        return cvRepository.findAll();
    }

    public CV getCVById(int id){
        Optional<CV> opt = cvRepository.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }else{
            throw new IDNotFoundException("There is no CV with ID : " + id);
        }
    }
}
