package com.company;

/**
 * Created by Admin on 16.08.2016.
 */
public interface MyList <T>{
    //public void addLast();
    //public void addFirst(T e);
    public void add(T e);
    public  T get(int i);
    public int size();
    public boolean isEmpty();
    public boolean remove(int i);

}
