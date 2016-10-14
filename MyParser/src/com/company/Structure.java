package com.company;

import java.util.LinkedHashMap;

/**
 * Created by aeryomin on 14.10.2016.
 */
public class Structure {
    private LinkedHashMap components = new LinkedHashMap<String,LinkedHashMap<String,LinkedHashMap<String,String>>>();
    private LinkedHashMap subjects= new LinkedHashMap<String,LinkedHashMap>();
    private LinkedHashMap inner = new LinkedHashMap<String,String>();

    public void setComponents(String name){
        components.put(name,subjects);
    }

    public void setSubjects(String name,LinkedHashMap inner){
        subjects.put(name,inner);
    }

    public void setAttributes(String name,String value){
        inner.put(name,value);
    }

    public void getSubjectAttributes(String name){

    }

    public void getSubjectByName(String name){

    }

    public void getComponentByName(String name){

    }

    public void showAll(){

    }

}
