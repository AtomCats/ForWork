package com.company.server.controller;

import com.company.server.SentPostRequest;
import com.company.server.entity.Remind;
import com.company.server.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService service;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    @ResponseBody
    public List<Remind> getReminders(){

        return service.getAll();
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Remind getReminder(@PathVariable long id){

        return service.getByID(id);
    }

    @RequestMapping(value = "/index.jsp", method = RequestMethod.POST)
    @ResponseBody
    public Remind saveReminder(@RequestBody Remind remind){

/*        SentPostRequest post = new SentPostRequest();
        Remind tempRemind = new Remind();
        tempRemind.setId(1);
        tempRemind.setTitle("Fucking piece of shit!");
        tempRemind.setRemindDate(new Date());*/
        return service.save(remind);
    }

    @RequestMapping(value = "/reminders/{id}", method = RequestMethod.POST)
    @ResponseBody
    public void deleteReminder(@PathVariable long id){

         service.remove(id);
    }
}
