package com.company;

/**
 * Created by Admin on 13.07.2016.
 */
public class DepartmentRoom {
    private int floor;

    public DepartmentRoom(){

    }
    public DepartmentRoom(int flr){
        this.floor=flr;
    }

     public void open(){
    }
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if (obj==null){
            return false;
        }
        if (obj.getClass() == this.getClass()) {
            DepartmentRoom dRoom = (DepartmentRoom) obj;
            if (this.floor == ((DepartmentRoom) obj).floor) {
                return true;
            }
        }
        return false;
    }
}
