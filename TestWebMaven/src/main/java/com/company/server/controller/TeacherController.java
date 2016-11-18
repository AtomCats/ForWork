package com.company.server.controller;

import com.company.server.entity.Student;
import com.company.server.entity.Teacher;
import com.company.server.service.StudentTestService;
import com.company.server.service.TeacherTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherTestService service;

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> getTeachers(){

        return service.getAll();
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Teacher getTeacher(@PathVariable long id){

        return service.getByID(id);
    }

    @RequestMapping(value = "/teachers/save", method = RequestMethod.POST)
    @ResponseBody
    public Teacher saveTeacher(@RequestBody Teacher teacher){

/*        SentPostRequest post = new SentPostRequest();
        Remind tempRemind = new Remind();
        tempRemind.setId(1);
        tempRemind.setTitle("Fucking piece of shit!");
        tempRemind.setRemindDate(new Date());*/
        return service.save(teacher);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteTeacher(@PathVariable long id){

        service.remove(id);
    }

}
