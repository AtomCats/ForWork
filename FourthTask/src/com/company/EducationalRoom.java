package com.company;

/**
 * Created by Admin on 13.07.2016.
 */
public class EducationalRoom extends DepartmentRoom {
    private int roomNum;

    @Override
    void open() {

    }

    public EducationalRoom(int num,int flr){
        super(flr);
        this.roomNum=num;
    }

    public boolean equals(Object obj){
        if(super.equals(obj)){
            EducationalRoom eRoom=(EducationalRoom)obj;
            if (this.roomNum==eRoom.roomNum){
                return true;
            }
        }
        return false;
    }
}
