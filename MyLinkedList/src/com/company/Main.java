package com.company;

/**
 * Created by Admin on 01.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList();
        LinkedListIterator itr;
        int i;
        itr = myList.zero();


        for (int k = 0; k < 15; k++) {
            myList.insert(k,itr);
            itr.move_next();
        }
    }
}
