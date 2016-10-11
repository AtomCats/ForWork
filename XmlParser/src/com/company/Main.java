package com.company;

import java.util.LinkedList;

/**
 * Created by aeryomin on 07.10.2016.
 */
public class Main {

    public static void main(String[] args) {
        Parser parser=new Parser();
        LinkedList<Computer> desktop ;
        desktop=parser.read("doc.xml");
        return;
    }
}
