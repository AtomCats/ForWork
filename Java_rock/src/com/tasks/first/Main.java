package com.tasks.first;

import java.io.IOException;
import java.io.BufferedReader;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Admin on 27.06.2016.
 */
public class Main {
    public static void main(String[ ] args)
    {   First task = new First();
        Scanner sc = new Scanner(System.in);
        System.out.println("Sup dude?");
        System.out.println("Dude,type some integers to calculate their sum \n Type first integer:");
        try {
            int first = sc.nextInt();
            System.out.println("Good boy) \n And type second integer");
            int sec = sc.nextInt();
            int res = task.greetings(first, sec);
            System.out.println("Here is your sum:" + res);
        }
        catch (InputMismatchException e) {
        task.greetings();
        }
    }
}
