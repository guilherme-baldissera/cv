package com.bjs.cv.controllers;

import com.bjs.cv.entities.*;
import com.bjs.cv.enums.Level;
import com.bjs.cv.services.CVService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CvControllerTests {

    private CvController cvController;
    private CVService cvService;

    @BeforeEach
    public void initEachTest(){
        cvService = Mockito.mock(CVService.class);
        cvController = new CvController(cvService);
    }

    @Test
    public void testGetAllCvs(){
        Address address = new Address("stret name", "ASN452", "London", "UK");
        UserInfo user = new UserInfo("Eduardo", 20, "19998446031",address);
        List<Education> educations = new ArrayList<>();
        educations.add(new Education("UFSCar", "Computer Science", "Bachelor Degree"));
        Skill skill = new Skill("python", Level.HIGH);
        List<Skill> skills = new ArrayList<>();
        skills.add(skill);
        List<WorkExperience> workExperiences = new ArrayList<>();
        workExperiences.add(new WorkExperience("dasdsa", "dsadsa", LocalDate.now(), LocalDate.now()));
        CV cv = new CV(user, educations, skills, workExperiences);

        List<CV> Cvs = new ArrayList<>();
        Cvs.add(cv);

        when(cvService.getAllCVs()).thenReturn(Cvs);
        Assert.isInstanceOf(ArrayList.class, cvController.getAllCVs(),"Should return a list of bridges");
        verify(cvService, times(1)).getAllCVs();
    }

}
