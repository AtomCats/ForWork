package com.company;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class DepartmentRoom implements Externalizable {
    private int floor;

    public DepartmentRoom(){

    }

    public DepartmentRoom(int flr){
        this.floor=flr;
    }

    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeInt(floor);
    }

    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
        floor=in.readInt();
    }

    public int setFl(int flr){
       return this.floor=flr;
    }

    public int getFloor(){
        return this.floor;
    }

      abstract void open();

}
