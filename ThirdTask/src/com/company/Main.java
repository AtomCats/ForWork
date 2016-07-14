package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
        Integer choise;
        Double[] values=new Double[4];
       // Double[][] first = {{2.0,5.0},{11.0,24.0},{19.0,33.0}};
        //Double[][] second = {{4.0,5.0},{15.0,3.0},{10.0,3.0}};
        //Complex aa=new Complex();
        Matrix a = new Matrix(4,4);
        Complex[][] arr=new Complex[4][4];
        Matrix b = new Matrix(4,4);
        a.add(b);
        show(a);
        //a.sub(b);


    }

    public static void show(Matrix a){
        for (int i=0;i<a.getMatr().length;i++){
            for (int j=0;j<a.getMatr()[0].length;j++){
                if(j==1){
                    System.out.print(a.getMatr()[i][j]+"i\n");///неправильно
                }
            }
        }
    }


}
