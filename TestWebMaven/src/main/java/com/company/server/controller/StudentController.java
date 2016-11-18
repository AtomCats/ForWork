package com.company.server.controller;


import com.company.server.entity.Student;
import com.company.server.service.StudentTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

        @Autowired
        private StudentTestService service;

        @RequestMapping(value = "/students", method = RequestMethod.GET)
        @ResponseBody
        public List<Student> getStudents(){

            return service.getAll();
        }

        @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
        @ResponseBody
        public Student getReminder(@PathVariable long id){

            return service.getByID(id);
        }

        @RequestMapping(value = "/students/save", method = RequestMethod.POST)
        @ResponseBody
        public Student saveReminder(@RequestBody Student student){

/*        SentPostRequest post = new SentPostRequest();
        Remind tempRemind = new Remind();
        tempRemind.setId(1);
        tempRemind.setTitle("Fucking piece of shit!");
        tempRemind.setRemindDate(new Date());*/
            return service.save(student);
        }

        @RequestMapping(value = "/students/{id}", method = RequestMethod.POST)
        @ResponseBody
        public void deleteReminder(@PathVariable long id){

            service.remove(id);
        }
    }


