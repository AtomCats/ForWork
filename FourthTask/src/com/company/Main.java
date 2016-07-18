package com.company;

/**
 * Created by Admin on 18.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        DepartmentRoom[] dRooms = {new LectureRoom(),new DecansOffice(),new EducationalRoom(1),new LectureRoom(),new LectureRoom()};
        LectureRoom[] lRooms=new LectureRoom[5];
        for (int i=0;i<dRooms.length;i++){
            dRooms[i].open();
            if (dRooms[i].getClass().getName().toString()=="com.company.LectureRoom"){
                lRooms[i]=(LectureRoom)dRooms[i];
            }
        }

    }
}