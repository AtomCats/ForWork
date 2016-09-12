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

    public int get_roomNumber(){
        return this.roomNum;
    }
    public boolean equals(Object obj){
        if(super.equals(obj)){
            if(obj instanceof EducationalRoom) {
                EducationalRoom eRoom = (EducationalRoom) obj;
                if (this.roomNum == eRoom.get_roomNumber()) {
                    return true;
                }
            }
        }
        return false;
    }
}
