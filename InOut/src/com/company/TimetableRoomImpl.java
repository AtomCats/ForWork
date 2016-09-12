package com.company;

/**
 * Created by Admin on 14.07.2016.
 */
public class TimetableRoomImpl implements TimetableRoom {
    private int startHour,endHour;
    public TimetableRoomImpl(int start,int end){
        this.startHour=start;
        this.endHour=end;
    }

    @Override
    public int getWorkdaySize() {
        return endHour-startHour;
    }
}
