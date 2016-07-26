package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class Main {

    public static void main(String[] args) {
        DepartmentRoom[] dRooms = {new LectureRoom(50,23,2),new DecansOffice("Antony",555,5),new EducationalRoom(423,4),new LectureRoom(68,642,6),new LectureRoom(800,801,8)};
        LectureRoom[] lRooms=new LectureRoom[5];
        for (int i=0;i<dRooms.length;i++){
            dRooms[i].open();
            if (dRooms[i] instanceof LectureRoom){
                lRooms[i]=(LectureRoom)dRooms[i];
            }
        }
        for (Object o:dRooms){
            for (Object o1:lRooms){
                if(o instanceof LectureRoom)
                {
                    o1=o;
                    break;
                }
            }

        }

        //-------------------------ArrayList
        Collection depRoom = new ArrayList();
        Collection lectRoom = new ArrayList();
        depRoom.add(new LectureRoom(50,23,2));
        depRoom.add(new DecansOffice("Antony",555,5));
        depRoom.add(new EducationalRoom(423,4));
        depRoom.add(new LectureRoom(68,642,6));
        depRoom.add(new LectureRoom(800,801,8));
        for (Object o:depRoom){
            for (Object o1:lectRoom){
                if(o instanceof LectureRoom)
                {
                    o1=o;
                    break;
                }
            }

        }

        for (Iterator it = depRoom.iterator(); it.hasNext(); ) {
            if (it.next() instanceof LectureRoom){
                lectRoom.add(it.next());
            }
        }


    }
}