package com.company;

/**
 * Created by Admin on 13.07.2016.
 */
public class LectureRoom extends EducationalRoom {
    private int lSeats;

    @Override
    public void open() {
        System.out.println("Аудитория открывается!");
    }

    public boolean equals(Object obj){
        if (super.equals(obj)){
           LectureRoom lRoom=(LectureRoom)obj;
            if(this.lSeats==lRoom.lSeats){
                return true;
            }
        }
        return false;
    }
}
