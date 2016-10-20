package com.company;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.regex.*;
import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Created by aeryomin on 12.10.2016.
 */
public class Parser extends DefaultHandler {


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
    private int catIndex=0,subjIndex=0,compIndex=0,attrIndex=0,propIndex=0;
    int counter=0;
    private String tempString;
    String elementName;
    public Parser(String url_str) {

        url = url_str;

    }


    // Начало
    public void startDocument() {

        elements            = 0;
        attributess          = 0;
        characters          = 0;
        ignorableWhitespace = 0;




    }

    // Конец
    public void endDocument() {

        out.flush();
        printInfo();

    }

///если встретился <
@Override
public void startElement(String uri,String localName, String qName, Attributes attributes) {

    elementName=qName;
        isNull=false;
        fuckingType="";
        elements++;
        if (attributes != null) {
            attributess += attributes.getLength();
        }
        if (counter==1){
            list.newCategory(qName);
            subjIndex=0;
            compIndex=0;
            attrIndex=0;
            propIndex=0;
            catIndex++;
        }
        else if(counter==2){

            list.newSubj(catIndex-1,qName);
            subjIndex++;
            compIndex=0;
            attrIndex=0;
            propIndex=0;
        }

        else if(counter==3){
            list.newComponent(subjIndex-1,qName);
            compIndex++;
            attrIndex=0;
            propIndex=0;
        }


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

                list.newProperty(qName,attributes.getQName(i),attributes.getValue(i));


                if(isNull){
                    out.print(" Error at element "+qName+" , in attribute with name  \""+attributes.getQName(i)+" \" !Attribute value can't be null. \n");

                }

            }


        }
        counter++;

    }



    public void endElement(String uri,String localName, String qName)   {

        counter--;

    }

// текст

    public void characters(char ch[], int start, int length) {

        characters += length;

        tempString = new String(ch, start, length);

        if (!tempString.equals("\n\n") && !tempString.equals("\n")) {

            if (counter>3){
                list.newAttribute(compIndex-1,elementName,tempString);
            }

            if (!fuckingType.equals("") && !checkWithRegExp(tempString, fuckingType)) {
                out.print("Тип значения элемента "+elementName+" не соответствует указанному, \""+fuckingType+"\"");
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

//===================================================
// Методы интерфейса ErrorHandler
//===============================

    // Последнее предупреждение
    public void warning(SAXParseException ex) {
        System.err.println("Warning at "+
                ex.getLineNumber()+" . "+
                ex.getColumnNumber()+"  -  "+
                ex.getMessage());
    }

    // Произошла ошибка
    public void error(SAXParseException ex) {
        System.err.println("Error at {"+
                ex.getLineNumber()+" . "+
                ex.getColumnNumber()+"  -  "+
                ex.getMessage());
    }

    // Такие ошибки исправить уже нельзя
    public void fatalError(SAXParseException ex) throws SAXException {
        System.err.println("Fatal error at {"+
                ex.getLineNumber()+" . "+
                ex.getColumnNumber()+"  -  "+
                ex.getMessage());
        throw ex;
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
        if (!list.checkComponents(list.categories)){
        }
        list.checkForMatchingIps(list.categories);

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







}

