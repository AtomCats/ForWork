package com.company;

import org.xml.sax.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by aeryomin on 06.10.2016.
 */
public class Parser {
    private String thisElement;
    Computer computer=new Computer();
    boolean component=false;

    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {

        if (thisElement.equalsIgnoreCase("component name")){
            computer.addComponents(new String(ch, start, length));
        }




        if (thisElement.equals("id")) {
            doc.setId(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("fam")) {
            doc.setFam(new String(ch, start, length));
        }
        if (thisElement.equals("name")) {
            doc.setName(new String(ch, start, length));
        }
        if (thisElement.equals("otc")) {
            doc.setOtc(new String(ch, start, length));
        }
        if (thisElement.equals("dateb")) {
            doc.setDateb(new String(ch, start, length));
        }
        if (thisElement.equals("datep")) {
            doc.setDatep(new String(ch, start, length));
        }
        if (thisElement.equals("datev")) {
            doc.setDatev(new String(ch, start, length));
        }
        if (thisElement.equals("datebegin")) {
            doc.setDatebegin(new String(ch, start, length));
        }
        if (thisElement.equals("dateend")) {
            doc.setDateend(new String(ch, start, length));
        }
        if (thisElement.equals("vdolid")) {
            doc.setVdolid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("specid")) {
            doc.setSpecid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("klavid")) {
            doc.setKlavid(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("stav")) {
            doc.setStav(new Float(new String(ch, start, length)));
        }
        if (thisElement.equals("progid")) {
            doc.setProgid(new Integer(new String(ch, start, length)));
        }
    }

    public Object read(String filename){
        String line;
        char[] chline;
        String type="";
        try{

            BufferedReader reader = new BufferedReader(new FileReader("\\.doc.xml"));
            while ((line=reader.readLine())!=null){
                int i=0;
                boolean reading=false;
                chline=line.toCharArray();
                while(chline[i]!=chline[chline.length]){
                    if (chline[i]=='<'){
                        i++;
                        while(chline[i]!='>'){
                            type=type+chline[i];
                            i++;
                        }
                    }
                }
            }

        }
    catch (FileNotFoundException e){
        System.out.println("File not found!");
    }
    catch (IOException e){

    }

    }


    private String[][] makeData(String name,String key){
        return new String[][]{{name},{key}};
    }

    private void isComponent(String data){
        if (data.equalsIgnoreCase("component")){
            component=true;
        }
        else component=false;

    }

}
