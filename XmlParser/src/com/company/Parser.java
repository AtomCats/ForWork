package com.company;

import org.xml.sax.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by aeryomin on 06.10.2016.
 */
public class Parser {
    private String thisElement;
    Computer computer=new Computer();
    LinkedList<Computer> computers = new LinkedList<>();
   // boolean component=false;
    private boolean element,readingType,readingPart,nameType,valueType,attributeType,readDone=false;
    private String name="",value="";
    private String type="",component="";


    public LinkedList<Computer> read(String filename){
        String line;
        char[] chline;
        int counter=0;
        try{

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line=reader.readLine())!=null){//строк до конца файла

                int i=0;
                component="";
                readingType=true;
                chline=line.toCharArray();
                while(i!=chline.length){//разбор строки

                    if(chline[i]=='\t'){
                        i++;
                        continue;
                    }

/*                    if(chline[i]=='<' && chline[i+1]=='/'){
                        component="";
                        i++;
                        while(chline[i]!='>'){
                            component=component+chline[i];
                            i++;
                        }
                        i++;

                        if(component.equalsIgnoreCase("/computer")){
                            computers.add(computer);
                            computer=new Computer();
                        }
                    }*/

                    if (readDone){


                        if (component.toLowerCase().contains("component")){
                            computer.addComponents(name,value);
                        }
                        else if (component.toLowerCase().contains("attribute")){
                            computer.setAttributes(name,value);
                        }

/*                    if (chline[i]=='<'){ ///открывающая конструкция

                        component="";
                        i++;
                        while(chline[i]!='>'){
                            component=component+chline[i];
                            i++;
                        }
                        i++;

                        if(component.equalsIgnoreCase("/computer")){
                            computers.add(computer);
                            computer=new Computer();
                        }
                        //component=false;
                    }*/



                        i=0;
                        readDone=false;
                        nameType=false;
                        valueType=false;
                        name="";
                        type="";
                        value="";
                        component="";
                        //continue;
                        break;

                    }

                    if (chline[i]=='<'){ ///открывающая конструкция

                        //component=true;
                        i++;
                        while(chline[i]!='>'){
                            component=component+chline[i];
                            i++;
                        }
                        i++;

                        if(component.equalsIgnoreCase("/computer")){
                            computers.add(computer);
                            computer=new Computer();
                        }

                        continue;
                        //component=false;
                    }
                    /////Читаем тип значения(имя,ключ,значение или тип аттрибута
                    if ( i<chline.length && chline[i]!=' ' && chline[i]!='<')
                    {
                        if ( chline[i]==34){
                            i++;
                            if (nameType && !valueType){

                                while( chline[i]!=34){
                                    name=name+chline[i];
                                    i++;
                                }
                            }

                            else if(valueType==true ){

                                while(chline[i]!=34){
                                    value=value+chline[i];
                                    i++;
                                }
                            }

                            if (nameType && valueType){
                                readDone=true;
                            }
                            i++;
                            type="";
                        }

                        else{

                            //i++;
                            while(chline[i]!='='){
                                type=type+chline[i];
                                i++;
                            }
                            if (type.toLowerCase().contains("name")){
                                nameType=true;
                            }
                            else  if(type.toLowerCase().contains("value") || type.toLowerCase().contains("key")){
                                valueType=true;
                            }
                            else if(type.toLowerCase().contains("attribute")){
                                attributeType=true;
                            }
                            i++;
                            continue;
                        }
                    }
                    ////Таки читаем значение


                    else if (i>=chline.length){
                        i=chline.length;
                        readDone=false;
                        nameType=false;
                        valueType=false;
                        name="";
                        type="";
                        value="";
                        component="";
                    }

                    else
                        i++;

                }

            }
        reader.close();
        }
    catch (FileNotFoundException e){
        System.out.println("File not found!");
    }
    catch (IOException e){

    }
        return computers;
    }


}
