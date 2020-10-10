package com.bjs.cv.controllers;

import com.bjs.cv.entities.CV;
import com.bjs.cv.entities.WorkExperience;
import com.bjs.cv.services.WorkExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("workexperience")
public class WorkExperienceController {

    private WorkExperienceService workExperienceService;

    public WorkExperienceController(WorkExperienceService workExperienceService){
        this.workExperienceService = workExperienceService;
    }

    @PostMapping("/cv/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CV add(@RequestBody WorkExperience workExperience, @PathVariable int id){
        return workExperienceService.add(workExperience, id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkExperience update(@RequestBody WorkExperience workExperience, @PathVariable int id){
        return workExperienceService.update(workExperience, id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkExperience getById(@PathVariable int id){
        return this.workExperienceService.getById(id);
    }

    @DeleteMapping(("/{id}"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        this.workExperienceService.deleteById(id);
    }
}
