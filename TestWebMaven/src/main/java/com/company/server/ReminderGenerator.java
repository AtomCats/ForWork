package com.company.server;


import com.company.server.entity.Remind;
import com.sun.javafx.scene.layout.region.Margins;

import java.util.Date;

public class ReminderGenerator {


    public static Remind create(){
        Remind remind = new Remind();
        remind.setId(1);
        remind.setTitle("Test bleat");
        remind.setRemindDate(new Date());
        return remind;
    }
}
