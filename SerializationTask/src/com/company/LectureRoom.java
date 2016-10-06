package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Admin on 13.07.2016.
 */
public class LectureRoom extends EducationalRoom {
    public int lSeats;

    public LectureRoom(){
        lSeats=0;
    }

    public LectureRoom(int seatsNum,int rNum,int flr){
        super(rNum,flr);
        this.lSeats=seatsNum;
        int first_num=get_first(rNum);
        if (flr!=first_num)throw new IllegalArgumentException();
        if((Integer)rNum==null) throw  new NullPointerException();
    }

    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(lSeats);
        out.writeInt(super.get_rNum());
        out.writeInt(super.getFloor());
    }

    public void readExternal(ObjectInput in) {
       try{
           lSeats=in.readInt();
           super.setRoomNum(in.readInt());
           super.setFl(in.readInt());
       }
       catch (IOException e){

       }
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

            if(obj instanceof LectureRoom) {

                LectureRoom lecRoom = (LectureRoom) obj;

                if (super.get_rNum() == lecRoom.get_rNum()) {
                    return true;
                }

                else if(super.getFloor()==lecRoom.getFloor()){
                    return true;
                }
                else if(lSeats==lecRoom.lSeats){
                    return true;
                }
                else
                    return false;





            }

        return false;
    }


    @Override
    public void open() {
        System.out.println("Аудитория открывается!\n");
    }


}
