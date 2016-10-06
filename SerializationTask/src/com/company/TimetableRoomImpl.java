package com.company;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Admin on 14.07.2016.
 */
public class TimetableRoomImpl implements TimetableRoom,Externalizable {
    private static int startHour,endHour;
    public TimetableRoomImpl(int start,int end){
        this.startHour=start;
        this.endHour=end;
    }

    public TimetableRoomImpl(){}

    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(startHour);
        out.writeInt(endHour);
    }

    public void readExternal(ObjectInput in) {
        try{
            startHour=in.readInt();
            endHour=in.readInt();
        }
        catch (IOException e){

        }
    }

    @Override
    public int getWorkdaySize() {
        return endHour-startHour;
    }
}
