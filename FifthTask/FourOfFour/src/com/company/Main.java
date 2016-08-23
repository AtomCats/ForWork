package com.company;

import java.util.*;

/**
 * Created by Admin on 23.08.2016.
 */
public class Main{
    public static void main(String[] args) {
        ArrayList arrList=new ArrayList();
        LinkedList linkList = new LinkedList();
        fillList(arrList,1000);
        fillList(linkList,1000);
        leadTime(arrList);
        leadTime(linkList);
    }

    public static void leadTime(List data){
        long en,st;
        int size=data.size();
        st=System.nanoTime();
        while (data.size()!=1){
            for (int i=0;i<data.size();i++){
                if(i%2==0){
                   data.remove(i);
                }
            }
        }
        en=System.nanoTime();
        System.out.println("Время выполнения для списка размером "+size+"\t"+(en-st));

    }
    public static void fillList(List data,int n){
        Random rand=new Random(100);
        while (n!=0){
            data.add(rand.nextInt());
            n--;
        }

    }
}
