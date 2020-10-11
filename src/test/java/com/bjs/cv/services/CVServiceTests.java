package com.bjs.cv.services;

import com.bjs.cv.daos.CVRepository;
import com.bjs.cv.entities.*;
import com.bjs.cv.enums.Level;
import com.bjs.cv.exceptions.IDNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class CVServiceTests {

    private CVService cvService;
    private CVRepository cvRepository;

    @BeforeEach
    public void initEachTest(){
        this.cvRepository = Mockito.mock(CVRepository.class);
        this.cvService = new CVServiceImp(cvRepository);
    }

    public CV createCV(){
        Address address = new Address("stret name", "ASN452", "London", "UK");
        UserInfo user = new UserInfo("Eduardo", 20, "19998446031",address);
        List<Education> educations = new ArrayList<>();
        educations.add(new Education("UFSCar", "Computer Science", "Bachelor Degree"));
        Skill skill = new Skill("python", Level.HIGH);
        List<Skill> skills = new ArrayList<>();
        skills.add(skill);
        List<WorkExperience> workExperiences = new ArrayList<>();
        workExperiences.add(new WorkExperience("Daitan", "Good Work", LocalDate.of(2018, Month.JUNE, 13), LocalDate.of(2020, Month.AUGUST, 01)));
        CV cv = new CV(user, educations, skills, workExperiences);
        cv.setId(1);
        return cv;
    }

    @Test
    public void testGetByIdSuccessfully(){

        CV cv = this.createCV();

        when(cvRepository.findById(cv.getId())).thenReturn(java.util.Optional.of(cv));
        Assert.isInstanceOf(CV.class, cvService.getCVById(cv.getId()),"Should return a instance of CV");
        verify(cvRepository, times(1)).findById(cv.getId());
    }

    @Test
    public void testGetByIdFailedInvalidID() {
        CV cv = null;
        when(cvRepository.findById(2)).thenReturn(java.util.Optional.ofNullable(cv));
        Assertions.assertThrows(IDNotFoundException.class,()->cvService.getCVById(2));
        verify(cvRepository, times(1)).findById(2);
    }

}
