package com.company;


import java.util.*;
import java.util.jar.Attributes;

/**
 * Created by aeryomin on 14.10.2016.
 */
public class Structure {

    LinkedList categories = new LinkedList<Category>();
    Category currentCat;
    Subject currentSubj;
    Component currentComp;
    Attribute currentAttr;
    Property currentProp;

    public void newCategory(String name){
        categories.add(new Category(name));
    }

    public void newSubj(int catIndex,String name){
        currentCat=(Category)categories.get(catIndex);
        currentCat.newSubject(name);
    }

    public void newComponent(int subjIndex,String name){
        currentSubj=currentCat.getSubject(subjIndex);
        currentSubj.addComponent(name);
    }

    public void newAttribute(int attrIndex,String attrName,String attrValue){
        currentComp = currentSubj.getComponent(attrIndex);
        currentComp.addAttribute(attrName,attrValue);

    }

    public void newProperty(String qName,String propName,String propVal){
        for (Object cat:categories){

            for (Object subj:((Category)cat).subjects){

                for (Object comp: ((Subject)subj).components){

                    if(qName== ((Component)comp).compName) {
                        ((Component) comp).setProperty(propName, propVal);
                        break;
                    }
                    else{
                        for (Object attr: ((Component)comp).attrs){
                            if(qName== ((Attribute)attr).attrName) {
                                ((Attribute)attr).setProperty(propName, propVal);
                                break;
                            }
                        }
                    }
                }
            }
        }
/*        currentAttr=currentComp.getAttribute(attrIndex);
        currentAttr.setProperty(propName,propVal);*/

    }


    public class Category{
        String catName;
        LinkedList properties = new LinkedList<Property>();
        public LinkedList subjects = new LinkedList<Subject>();

        public Category(String name){
            catName = name;
        }

        public void newSubject(String name){
        subjects.add(new Subject(name));
        }

        public Subject getSubject(int index){
            return  (Subject)subjects.get(index);
        }
    }


    private class Subject{
        String subName;
        LinkedList components = new LinkedList<Component>();
        LinkedList properties = new LinkedList<Property>();

        public Subject(String name){
            subName = name;
        }

        public void addComponent(String name){
            components.add(new Component(name));
        }


        public Component getComponent(int index){
            return (Component)components.get(index);
        }


    }

    public class Component{
        String compName;
        LinkedList properties = new LinkedList<Property>();
        LinkedList attrs = new LinkedList<com.company.Structure.Attribute>();

        public Component (String name){
            compName=name;
        }

        public void addAttribute(String name,String value){
            attrs.add(new Attribute(name,value));
        }

        public void  setProperty(String name,String value){
            properties.add(new Property(name,value));
        }

        public Attribute getAttribute(int attrIndex){
            return (Attribute)attrs.get(attrIndex);
        }
    }


    private class Attribute{
        LinkedList properties = new LinkedList<Property>();
        String attrName,attVal;

        public Attribute(String name,String value){
            attrName=name;
            attVal=value;
        }

        public void  setProperty(String name,String value){
            properties.add(new Property(name,value));
        }
    }

    private class Property{
        String pName,pValue;
        public Property(String name,String value){
            pName=name;
            pValue=value;
        }

    }

}
