package com.company;

/**
 * Created by Admin on 13.07.2016.
 */
public class LectureRoom extends EducationalRoom {
    public int lSeats;

    public LectureRoom(int seatsNum,int rNum,int flr){
        super(rNum,flr);
        this.lSeats=seatsNum;
        int first_num=get_first(rNum);
        if (flr!=first_num)throw new IllegalArgumentException();
        if((Integer)rNum==null) throw  new NullPointerException();
    }
    private int get_first(int num){
        int n=num;
        while (n>0){
            n=n/10;
            if ((n/10)==0){
                break;
            }
        }
        return n;
    }
    @Override
    public void open() {
        System.out.println("Аудитория открывается!\n");
    }


}
