package com.company;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class Main {

private static int choice =1;

    public static void main(String[] args) {
        ObjectOutputStream outSer;
        ObjectInputStream inSer;
        Type cl;
        try{
            DepartmentRoom[] dRooms = {new LectureRoom(50,555,5),new DecansOffice("Antony",556,5),new EducationalRoom(423,4),new LectureRoom(68,642,6),new LectureRoom(800,801,8)};
            cl= dRooms[0].getClass().getGenericSuperclass();
            DepartmentRoom[] roomsClone = new DepartmentRoom[dRooms.length];
            //roomsClone[0]= new LectureRoom(444,33,3);
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

            switch (choice){
                case 0:
                    //Serialization

                    outSer = new ObjectOutputStream(new FileOutputStream("serializedArrayOfRooms.out"));
                    System.out.println("Saving object \n");
                    outSer.writeObject(dRooms);
                    outSer.close();
                    inSer = new ObjectInputStream(new FileInputStream("serializedArrayOfRooms.out"));
                    System.out.println("Recovering object \n");
                    roomsClone=(DepartmentRoom[])inSer.readObject();
                    inSer.close();

                    for(int i=0;i<dRooms.length;i++){

                        if(dRooms[i].equals(roomsClone[i])){

                            System.out.println("Fuck yeah!Element #"+i+" from deserialized array is equals to element from original array \n");

                        }
                        else{
                            System.out.println("Shit!!!!If you see this you can understand my pain(( \n");

                        }

                    }
                    break;
                    //////////////////////

                case 1:
                    outSer = new ObjectOutputStream(new FileOutputStream("serializedRooms.out"));
                    System.out.println("Saving objects \n");
                    for (DepartmentRoom d:dRooms){
                        outSer.writeObject(d);
                    }
                    outSer.close();
                    inSer = new ObjectInputStream(new FileInputStream("serializedRooms.out"));
                    System.out.println("Recovering objects \n");


                    //DepartmentRoom ob= (DepartmentRoom) inSer.readObject();
                    for (int i=0;i<dRooms.length;i++){
                       roomsClone[i]=(DepartmentRoom) inSer.readObject();
                    }
                    inSer.close();

                    for(int i=0;i<dRooms.length;i++){

                        if(dRooms[i].equals(roomsClone[i])){

                            System.out.println("Fuck yeah!Element #"+i+" from deserialized array is equals to element from original array \n");

                        }
                        else{
                            System.out.println("Shit!!!!If you see this you can understand my pain(( \n");

                        }

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
        catch (FileNotFoundException e){
            return;
        }
        catch (IOException e){
            return;
        }
        catch (ClassNotFoundException e){
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