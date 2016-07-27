package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try{
            DepartmentRoom[] dRooms = {new LectureRoom(50,555,5),new DecansOffice("Antony",555,5),new EducationalRoom(423,4),new LectureRoom(68,642,7),new LectureRoom(800,801,8)};
            LectureRoom[] lRooms=new LectureRoom[5];
            for (int i=0;i<dRooms.length;i++){
                dRooms[i].open();
                if (dRooms[i] instanceof LectureRoom){
                    lRooms[i]=(LectureRoom)dRooms[i];
                }
            }
            int counter=0;
            for (DepartmentRoom o:dRooms){

                if(o instanceof LectureRoom)
                {
                    lRooms[counter]=(LectureRoom)o;
                    counter++;
                }


            }
            //-------------------
            for (int i=0;i<dRooms.length-1;i++){
                if (dRooms[i].getFloor()==dRooms[i+1].getFloor())
                {
                    if (!dRooms[i].getClass().isAssignableFrom(dRooms[i+1].getClass())){
                        throw new IllegalArgumentException("Invalid value");
                    }
                }
            }

        }
        catch (IllegalArgumentException e){
            return;
        }
        catch (NullPointerException b){
            return;
        }


        //-------------------------ArrayList
        List<DepartmentRoom> depRoom = new ArrayList();
        List<LectureRoom> lectRoom = new ArrayList();
        depRoom.add(new LectureRoom(50,23,2));
        depRoom.add(new DecansOffice("Antony",555,5));
        depRoom.add(new EducationalRoom(423,4));
        depRoom.add(new LectureRoom(68,642,6));
        depRoom.add(new LectureRoom(800,801,8));
        for (Object o:depRoom){
                if(o instanceof LectureRoom)
                {
                    lectRoom.add((LectureRoom) o);
                }
        }

        for (Iterator it = depRoom.iterator(); it.hasNext(); ) {
            if (it.next() instanceof LectureRoom){
                lectRoom.add((LectureRoom) it.next());
            }
        }
    }
}