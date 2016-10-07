package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aeryomin on 06.10.2016.
 */
public class Computer {
    private  ArrayList<String[][]> components=new ArrayList<>();
    private  ArrayList<String> attributes;

    public Computer(){}

    public Computer(ArrayList comps,ArrayList attrs){
        components.addAll(comps);
        attributes.addAll(attrs);

    }
    ////Components
    public void addComponents(String name,String value){
        components.add(new String[][]{{name},{value}});
    }

    public ArrayList getComponents(){
        return components;
    }

    ////Attributes
    public void setAttributes(ArrayList attrs){
        attributes.addAll(attrs);
    }

    public ArrayList getAttributes(){
        return attributes;
    }

}