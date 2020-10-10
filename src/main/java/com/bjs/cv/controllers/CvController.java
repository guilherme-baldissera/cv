package com.bjs.cv.controllers;

import com.bjs.cv.entities.*;
import com.bjs.cv.services.CVService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("cv")
public class CvController {

    private CVService cvService;

    public CvController(CVService cvService){
        this.cvService = cvService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CV addCV(@RequestBody CV cv){
        return cvService.addOrUpdateCV(cv);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCV(@PathVariable int id){
        cvService.deleteCV(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CV> getAllCVs(){
        return cvService.getAllCVs();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CV getCVById(@PathVariable int id){
        return cvService.getCVById(id);
    }
}
