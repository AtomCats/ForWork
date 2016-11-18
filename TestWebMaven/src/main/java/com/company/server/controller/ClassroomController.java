package com.company.server.controller;

import com.company.server.entity.Classroom;
import com.company.server.service.ClassroomTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassroomController {

    @Autowired
    private ClassroomTestService service;

    @RequestMapping(value = "/classrooms", method = RequestMethod.GET)
    @ResponseBody
    public List<Classroom> getClassrooms(){

        return service.getAll();
    }

    @RequestMapping(value = "/classrooms/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Classroom getClassroom(@PathVariable long id){

        return service.getByID(id);
    }

    @RequestMapping(value = "/classrooms/save", method = RequestMethod.POST)
    @ResponseBody
    public Classroom saveClassroom(@RequestBody Classroom classroom){

/*        SentPostRequest post = new SentPostRequest();
        Remind tempRemind = new Remind();
        tempRemind.setId(1);
        tempRemind.setTitle("Fucking piece of shit!");
        tempRemind.setRemindDate(new Date());*/
        return service.save(classroom);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteClassroom(@PathVariable long id){

        service.remove(id);
    }
}
