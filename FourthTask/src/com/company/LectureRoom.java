package com.company;

/**
 * Created by Admin on 13.07.2016.
 */
public class LectureRoom extends EducationalRoom {
    public int lSeats;

    public LectureRoom(int seatsNum,int rNum,int flr){
        super(rNum,flr);
        this.lSeats=seatsNum;
    }
    @Override
    public void open() {
        System.out.println("Аудитория открывается!\n");
    }


}
