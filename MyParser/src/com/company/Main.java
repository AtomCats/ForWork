package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by aeryomin on 12.10.2016.
 */
public class Main {

    public static void main(String[] args) {
        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            Parser saxp = new Parser("doc.xml");
            parser.parse(new File("doc.xml"), saxp);

        }
        catch (SAXException e){

        }
        catch (IOException e){

        }
        catch (ParserConfigurationException e){

        }

    }


}
