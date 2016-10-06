package com.company;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/**
 * Created by Admin on 13.07.2016.
 */
public class DecansOffice extends EducationalRoom implements TimetableRoom {
    private String dName;
    private TimetableRoom tRoom;
    private static final int DAY_START=8,DAY_END=18;

    public DecansOffice(){

    }

    public  DecansOffice(String decName,int rNum,int flr){
        super(rNum,flr);
        dName=decName;
        tRoom = new TimetableRoomImpl(this.DAY_START,this.DAY_END);
        int first_num=get_first(rNum);
        if (flr!=first_num)throw new IllegalArgumentException("Invalid value");
    }

    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeObject(dName);
        out.writeInt(super.get_rNum());
        out.writeInt(super.getFloor());
        out.writeObject(tRoom);
    }

    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
        dName=(String)in.readObject();
        super.setRoomNum(in.readInt());
        super.setFl(in.readInt());
        tRoom=(TimetableRoom)in.readObject();
    }

    @Override
    public void open() {
        System.out.println("Деканат открывается!\n");
    }

    @Override
    public int getWorkdaySize() {
        return tRoom.getWorkdaySize();
    }

    private int get_first(int num){
        int n=num;
        while (n>0){
            n=n/10;
            if ((n/10)==0){
                break;
            }
        }
        return n;
    }


    public boolean equals(Object obj){
            if(obj instanceof DecansOffice) {
                DecansOffice decRoom = (DecansOffice) obj;
                if (super.get_rNum() == decRoom.get_rNum()) {
                    return true;
                }
                else if (this.dName==decRoom.dName){
                    return true;
                }
                else if(super.getFloor()==decRoom.getFloor()){
                    return true;
                }
                else if(tRoom==decRoom.tRoom){
                    return true;
                }
                else
                    return false;
            }
        return false;
    }

}
