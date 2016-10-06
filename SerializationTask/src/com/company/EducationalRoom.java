package com.company;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by Admin on 13.07.2016.
 */
public class EducationalRoom extends DepartmentRoom {
    private int roomNum;

    @Override
    void open() {

    }
    public EducationalRoom(){
        roomNum=0;
    }

    public EducationalRoom(int num,int flr){
        super(flr);
        this.roomNum=num;
    }
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(roomNum);
        out.writeInt(super.getFloor());
    }

    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
        roomNum=in.readInt();
        super.setFl(in.readInt());
    }

    public int get_rNum(){
        return this.roomNum;
    }

    public void setRoomNum(int num){this.roomNum=num;}
    public boolean equals(Object obj){

            if(obj instanceof EducationalRoom) {
                EducationalRoom eRoom = (EducationalRoom) obj;
                if (this.roomNum == eRoom.get_rNum()) {
                    return true;
                }
            }

        return false;
    }
}
