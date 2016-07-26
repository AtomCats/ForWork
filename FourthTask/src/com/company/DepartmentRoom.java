package com.company;


public abstract class DepartmentRoom {
    private int floor;

    public DepartmentRoom(int flr){
        this.floor=flr;
    }

    public int setFl(int flr){
       return this.floor=flr;
    }
    public int getFloor(){
        return this.floor;
    }

      abstract void open();

}
