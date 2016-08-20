package com.company;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

/**
 * Created by Admin on 01.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        LinkedListImpl<Integer> myList = new LinkedListImpl<>();
        Iterator<Integer> itr= myList.iterator();
        int test;
        Random r = new Random();
        for(int i=0;i<8;i++){
            myList.add(r.nextInt());
        }

        test=myList.size();
        test=(int)myList.get(5);
        boolean answer = myList.remove(5);
        test=(int)myList.get(5);
        test=myList.size();
        answer = myList.isEmpty();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
