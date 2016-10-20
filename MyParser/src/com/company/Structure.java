package com.company;


import java.util.*;
import java.util.jar.Attributes;

import static java.lang.System.out;

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

    public void checkForMatchingIps(LinkedList categories){

        LinkedList<String> idFromPc = new LinkedList<>();
        LinkedList<String> printerId = new LinkedList<>();

        for (Object cat:categories){

            for (Object subj:((Category)cat).subjects){

                for (Object comp: ((Subject)subj).components){

                        for (Object attr: ((Component)comp).attrs){

                            if(((Component)comp).compName.equalsIgnoreCase("computer" )&& ((Attribute)attr).attrName.equalsIgnoreCase("printerid")){
                                idFromPc.add(((Attribute)attr).attVal);
                            }
                            else if(((Component)comp).compName.equalsIgnoreCase("printerid") && ((Attribute)attr).attrName.equalsIgnoreCase("printerid")) {
                                printerId.add(((Attribute)attr).attVal);
                            }

                            }
                }
            }
        }
        int idCount=0;
        boolean matching=false;
        for (String id:idFromPc){
            matching=false;
            for (String printId:printerId){
                if (id.equalsIgnoreCase(printId)){
                    matching=true;
                }
            }
            if (!matching){
                out.println("Принтер с ID "+id+" отсутствует в списке");
            }
        }
    }

    public boolean checkComponents(LinkedList categories){
        Boolean good=false;
        LinkedList<String> componentName = new LinkedList<String>();
        componentName.add("motherboard");
        componentName.add("processor");
        componentName.add("ram");
        componentName.add("psu");
        Component testingSubject=new Component("test");
        int comCounter=0;
        for (Object cat:categories){

            if(((Category)cat).catName.toLowerCase()=="computers"){

                for (Object subj:((Category)cat).subjects){

                    for (Object comp: ((Subject)subj).components){
                        switch (((Component)comp).compName.toLowerCase()){
                            case "motherboard":
                                good=true;
                                comCounter++;
                                componentName.remove("motherboard");
                                break;
                            case "processor":
                                good=true;
                                comCounter++;
                                componentName.remove("processor");
                                break;
                            case "ram":
                                good=true;
                                comCounter++;
                                componentName.remove("ram");
                                break;
                            case "psu":
                                good=true;
                                comCounter++;
                                componentName.remove("psu");
                                break;
                        }
                    }
                    if ( comCounter<4){
                        good=false;
                        out.println("В составе компьютера "+((Subject)subj).subName+" отсутствуют компоненты : ");
                        for(String missing:componentName){
                            out.println(missing);
                        }
                    }
                }
            }
        }
    return good;
    }


}
