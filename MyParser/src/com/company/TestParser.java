package com.company;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.regex.*;
import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by aeryomin on 12.10.2016.
 */
public class TestParser extends DefaultHandler {


    // private PrintWriter out;
    Structure list = new Structure();
    LinkedHashMap attrMap = new LinkedHashMap<String,String >();
    LinkedHashMap temp;
    private int elements;
    private int attributess;
    private int characters;
    private int ignorableWhitespace;
    private String url;
    private String fuckingType;
    private boolean hasType=false;
    private boolean isNull=false;
    private boolean previous=false;
    private boolean tagClosed = true;
    private boolean isRoot=false;
    private String nullName="";
    LinkedList<String> listOfTags = new LinkedList<>();
    String name;
    int innerCount=0;
    LinkedHashMap components = new LinkedHashMap<String,String>();
    public TreeMap tMap = new TreeMap();


    int counter=0;
    public TestParser(String url_str) {

        url = url_str;

    }


    // Начало
    public void startDocument() {

        // Статистика
        elements            = 0;
        attributess          = 0;
        characters          = 0;
        ignorableWhitespace = 0;


        // Процессорные инструкции

        out.println("<?xml version=1.0?>");

    }

    // Конец
    public void endDocument() {

        out.flush();
        printInfo();

    }

    ///если встретился <
    @Override
    public void startElement(String uri,String localName, String qName, Attributes attributes) {
        innerCount++;
        listOfTags.add(qName);
        name=qName;
        isNull=false;
        fuckingType="";
        elements++;
        if (attributes != null) {
            attributess += attributes.getLength();
        }

        // Печать тэга элемента вместе со списком его атрибутов,
        // например, <elem id="48">
        out.print('<');
        out.print(qName);

        if (attributes != null) {
            int len = attributes.getLength();
            for (int i = 0; i < len; i++) {
                ////////указан или нет тип атрибута?
                if(attributes.getQName(i).equalsIgnoreCase("attributeType")){
                    fuckingType=attributes.getValue(i);
                }
                ///////пустой атрибут?
                if(attributes.getValue(i).equalsIgnoreCase("")){
                    isNull=true;
                }

                //list.setAttributes()


                out.print(' ');
                out.print(attributes.getQName(i));
                out.print("=\"");
                if(isNull)
                    out.print("\t Error!Attribute value can't be null. \t");
                else
                    out.print(attributes.getValue(i));
                out.print('"');
            }


        }
        out.println('>');


    }



    public void endElement(String uri,String localName, String qName)   {

        out.println("</"+qName+">");
        listOfTags.removeLast();
        innerCount--;
        tagClosed=true;

    }

// текст

    public void characters(char ch[], int start, int length) {

        characters += length;
        out.println(new String(ch, start, length));

        String tempString = new String(ch, start, length);


        if (!tempString.equals("\n\n") && !tempString.equals("\n")) {
            components.put(name,tempString);

            if (!fuckingType.equals("") && !checkWithRegExp(tempString, fuckingType)) {
                out.print("Тип значения не соответствует указанному");
            }

        }
    }



// Инструкции XML-процессору

    public void processingInstruction (String target, String data) {

        out.print("<?");
        out.print(target);
        if (data != null && data.length() > 0) {
            out.print(' ');
            out.print(data);
        }
        out.print("?>");

    }



//=======================================================
// Вывести информацию о документе
//===============================

    public void printInfo() {

        out.println();

        out.println("Документ "+url+" был успешно обработан");

        out.println("Элементов : "+elements);
        out.println("Атрибутов : "+attributess);
        out.println("Символов  : "+characters);

    }

    public static boolean checkWithRegExp(String str,String type){
        Pattern p=null;
        Matcher m=null;
        boolean result=false;
        if (type.equalsIgnoreCase("string")){
            p = Pattern.compile("^[a-zA-Z.]+");
        }

        else if(type.equalsIgnoreCase("integer")){
            p = Pattern.compile("^[0-9.]+");

        }

        else if(type.equalsIgnoreCase("boolean")){
            p = Pattern.compile("^([Tt]rue|[Ff]alse)$");
        }

        else if(type.equalsIgnoreCase("double")){
            p = Pattern.compile("^(0-9)+\\.(0-9)+$");
        }
        try {
            m = p.matcher(str);
            result= m.matches();
        }
        catch (NullPointerException e){

        }
        return result;
    }

    private void checkForMatchingIps(LinkedList data){

    }
    private void checkComponents(LinkedList data){

    }





}

