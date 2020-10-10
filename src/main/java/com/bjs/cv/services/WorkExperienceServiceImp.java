package com.bjs.cv.services;

import com.bjs.cv.daos.WorkExperienceRepository;
import com.bjs.cv.entities.CV;
import com.bjs.cv.entities.WorkExperience;
import com.bjs.cv.exceptions.IDNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkExperienceServiceImp implements WorkExperienceService {

    private WorkExperienceRepository workExperienceRepository;
    private CVService cvService;

    public WorkExperienceServiceImp(WorkExperienceRepository workExperienceRepository, CVService cvService){
        this.workExperienceRepository = workExperienceRepository;
        this.cvService = cvService;
    }

    public CV add(WorkExperience workExperience, int cvId){
        CV cv= cvService.getCVById(cvId);
        cv.getWorkExperiences().add(workExperience);
        return cvService.addOrUpdateCV(cv);
    }

    public WorkExperience update(WorkExperience workExperience, int id){
        WorkExperience updatedWorkExperience = this.getById(id);
        updatedWorkExperience.setCompanyName(workExperience.getCompanyName());
        updatedWorkExperience.setJobDescription(workExperience.getJobDescription());
        updatedWorkExperience.setStartDay(workExperience.getStartDay());
        updatedWorkExperience.setEndDay(workExperience.getEndDay());
        return this.workExperienceRepository.save(updatedWorkExperience);
    }

    public WorkExperience getById(int id){
        Optional<WorkExperience> opt = this.workExperienceRepository.findById(id);
        if(!opt.isPresent()){
            throw new IDNotFoundException("There is no WorkExperience with ID : " + id);
        }
        return opt.get();
    }

    public void deleteById(int id){
        this.getById(id);
        this.workExperienceRepository.deleteById(id);
    }
}
