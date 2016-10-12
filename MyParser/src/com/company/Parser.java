package com.company;

import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;

import static java.lang.System.out;

/**
 * Created by aeryomin on 12.10.2016.
 */
public class Parser extends DefaultHandler {


   // private PrintWriter out;

    private int elements;
    private int attributes;
    private int characters;
    private int ignorableWhitespace;
    private String url;

    public Parser(String url_str) {

        url = url_str;

    }


//=======================================================
// Обработчики событий. Методы интерфейса DocumentHandler
//========================

    // Начало документа
    public void startDocument() {

        // Статистика
        elements            = 0;
        attributes          = 0;
        characters          = 0;
        ignorableWhitespace = 0;


        // Процессорные инструкции

        out.println("<?xml version=1.0?>");

    }

    // Конец документа
    public void endDocument() {

        out.flush();

    }

// Встретился открывающий тэг элемента //

    public void startElement(String name, Attributes attrs) {

        elements++;
        if (attrs != null) {
            attributes += attrs.getLength();
        }

        // Печать тэга элемента вместе со списком его атрибутов,
        // например, <elem id="48">
        out.print('<');
        out.print(name);
        if (attrs != null) {
            int len = attrs.getLength();
            for (int i = 0; i < len; i++) {
                out.print(' ');
                out.print(attrs.getQName(i));
                out.print("=\"");
                out.print(attrs.getValue(i));
                out.print('"');
            }
        }
        out.println('>');


    }


// Встретился закрывающий тэг элемента

    public void endElement(String name) {

        out.println("</"+name+">");

    }

// Текстовые символы

    public void characters(char ch[], int start, int length) {

        characters += length;

        out.println(new String(ch, start, length));

    }

// Необрабатываемые символы(например, содержимое секции CDATA)

    public void ignorableWhitespace(char ch[], int start, int length) {

        characters(ch, start, length);

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
        out.println("Атрибутов : "+attributes);
        out.println("Символов  : "+characters);

    }

}

