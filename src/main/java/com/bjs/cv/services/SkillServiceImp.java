package com.bjs.cv.services;

import com.bjs.cv.daos.SkillRepository;
import com.bjs.cv.entities.CV;
import com.bjs.cv.entities.Skill;
import com.bjs.cv.exceptions.IDNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SkillServiceImp implements SkillService {

    private SkillRepository skillRepository;
    private CVService cvService;

    public SkillServiceImp(SkillRepository skillRepository, CVService cvService){
        this.skillRepository = skillRepository;
        this.cvService = cvService;
    }


    public CV add(Skill skill, int userId){
        CV cv= cvService.getCVById(userId);
        cv.getSkills().add(skill);
        return cvService.addOrUpdateCV(cv);
    }

    public Skill update(Skill skill, int skillId){
        Skill updatedSkill = this.getById(skillId);
        updatedSkill.setSkillName(skill.getSkillName());
        updatedSkill.setLevel(skill.getLevel());
        return this.skillRepository.save(updatedSkill);
    }

    public Skill getById(int id){
        Optional<Skill> opt = this.skillRepository.findById(id);
        if(!opt.isPresent()){
            throw new IDNotFoundException("There is no Skill with ID : " + id);
        }
        return opt.get();
    }

    public void deleteById(int id){
        this.getById(id);
        this.skillRepository.deleteById(id);
    }
}
