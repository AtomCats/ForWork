package com.company;

/**
 * Created by Admin on 13.07.2016.
 */
public class DecansOffice extends EducationalRoom implements TimetableRoom {
    private String dName;
    public TimetableRoom tRoom;
    private static int dayStart=8,dayEnd=18;

    public  DecansOffice(){
        TimetableRoom a = new TimetableRoomImpl(this.dayStart,this.dayEnd);
        this.tRoom=a;
    }
    @Override
    public void open() {
        System.out.println("Деканат открывается!\n");
    }

    @Override
    public int getWorkdaySize() {
        return dayEnd-dayStart;
    }

}
