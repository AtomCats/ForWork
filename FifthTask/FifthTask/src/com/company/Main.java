package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by Admin on 21.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        String curDir = new File("").getAbsolutePath();
        String fName="text.txt";
        String text;
        String[] buffer;
        String file = curDir+"\\"+fName;
        LinkedList<String> wordList= new LinkedList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((text=in.readLine())!=null){
                wordList.addAll(Arrays.asList(text.split("[^a-zA-Z\']+")));
            }
            for (String word:wordList){
                System.out.println("Слово "+word+" встречается "+Collections.frequency(wordList,word)+" раз" );
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
