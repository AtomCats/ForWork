package com.company;

import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) {
        String fileName = "out.txt";
        File file = new File(fileName);
        MyFile fileOperations = new MyFile();
        try{


            //-------------------------ArrayList
            Collection<DepartmentRoom> depRoom = new ArrayList();
            Collection<LectureRoom> lectRoom = new ArrayList();
            LinkedList in = new LinkedList();
            LinkedList out = new LinkedList();
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
            fileOperations.writeToFile(file,depRoom);
            fileOperations.ReadFile(file,in);
            fileOperations.ReadFromZip("\\task.rar","out.txt",in);
            for (Object o :in){
                System.out.println(o.toString());
            }

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