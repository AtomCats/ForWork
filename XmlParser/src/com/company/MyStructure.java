package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aeryomin on 06.10.2016.
 */
public class MyStructure {
    private  ArrayList<String[][]> components=new ArrayList<>();
    private  ArrayList<String[][]> attributes=new ArrayList<>();

    public MyStructure(){}

    public MyStructure(ArrayList comps,ArrayList attrs){
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
    public void setAttributes(String name,String value){

        attributes.add(new String[][]{{name},{value}});
    }

    public ArrayList getAttributes(){
        return attributes;
    }

}
