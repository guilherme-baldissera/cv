package com.bjs.cv.controllers;

import com.bjs.cv.entities.CV;
import com.bjs.cv.entities.Skill;
import com.bjs.cv.services.SkillService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("skill")
public class SkillController {

    private SkillService skillService;

    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @PostMapping("/cv/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CV add(@RequestBody Skill skill, @PathVariable int id){
        return skillService.add(skill, id);
    }

    @PutMapping("/{skillId}")
    @ResponseStatus(HttpStatus.OK)
    public Skill update(@RequestBody Skill skill, @PathVariable int skillId){
        return skillService.update(skill, skillId);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Skill getById(@PathVariable int id){
        return this.skillService.getById(id);
    }

    @DeleteMapping(("/{id}"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        this.skillService.deleteById(id);
    }
}
