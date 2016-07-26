package com.company;

/**
 * Created by Admin on 13.07.2016.
 */
public class DecansOffice extends EducationalRoom implements TimetableRoom {
    private String dName;
    private TimetableRoom tRoom;
    private static final int DAY_START=8,DAY_END=18;

    public  DecansOffice(String decName,int rNum,int flr){
        super(rNum,flr);
        dName=decName;
        tRoom = new TimetableRoomImpl(this.DAY_START,this.DAY_END);
    }
    @Override
    public void open() {
        System.out.println("Деканат открывается!\n");
    }

    @Override
    public int getWorkdaySize() {
        return tRoom.getWorkdaySize();
    }

}
