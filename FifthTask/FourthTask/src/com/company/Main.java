package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try{


            //-------------------------ArrayList
            Collection<DepartmentRoom> depRoom = new ArrayList();
            Collection<LectureRoom> lectRoom = new ArrayList();
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

            for (DepartmentRoom o:depRoom)
            {
                for (DepartmentRoom a:depRoom){
                    if (o.equals(a)){
                        continue;
                    }
                    else if(o.getFloor()==a.getFloor() && !o.getClass().isAssignableFrom(a.getClass())){
                        throw new MyException("\"Номера помещений не может быть одинаковым!\"");
                    }
                }

            }


                //-----------------------

        }
        catch (IllegalArgumentException e){
            System.out.println("Wrong room number value");
            return;
        }
        catch (NullPointerException b){
            System.out.println("Room number can't be 0");
            return;
        }
        catch (MyException c) {
            System.out.println("Номера помещений не может быть одинаковым!");
            return;
        }


    }
}