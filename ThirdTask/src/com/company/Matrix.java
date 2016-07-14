package com.company;
import java.util.*;

public class Matrix {
    private Complex[][] matrix;
    Random rand = new Random(50);

    public Matrix(Complex[][] a){
        this.matrix=a.clone();

    }

    public Matrix(int a, int b){
        this.matrix= new Complex[a][b];
        for (int i=0;i<this.matrix.length;i++){
            for (int j=0;j<this.matrix[0].length;j++){
                this.matrix[i][j]=new Complex();
            }
        }
    }

    public Complex[][] getMatr(){
        return this.matrix;
    }

    public void add(Matrix b){
        if(this.matrix.length>b.getMatr().length) {
            for (int i = 0; i < b.getMatr().length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    this.matrix[i][j].setReal(this.matrix[i][j].getReal()+b.getMatr()[i][j].getReal());
                    this.matrix[i][j].setImg(this.matrix[i][j].getImg() + b.getMatr()[i][j].getImg());
                }
            }
        }else{
            for (int i=0;i<this.matrix.length;i++){
                for (int j=0;j<this.matrix[0].length;j++){
                    this.matrix[i][j].setReal(this.matrix[i][j].getReal()+b.getMatr()[i][j].getReal());
                    this.matrix[i][j].setImg(this.matrix[i][j].getImg() + b.getMatr()[i][j].getImg());
                }
            }
        }

    }

    public void sub(Matrix b) {
        if (this.matrix.length > b.getMatr().length) {
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[0].length; j++) {
                    this.matrix[i][j].setReal(this.matrix[i][j].getReal()-b.getMatr()[i][j].getReal());
                    this.matrix[i][j].setImg(this.matrix[i][j].getImg() - b.getMatr()[i][j].getImg());
                }
            }
        }else{
            for (int i=0;i<this.matrix.length;i++){
                for (int j=0;j<this.matrix[0].length;j++){
                    this.matrix[i][j].setReal(this.matrix[i][j].getReal()-b.getMatr()[i][j].getReal());
                    this.matrix[i][j].setImg(this.matrix[i][j].getImg() - b.getMatr()[i][j].getImg());
                }
            }
        }
    }


    }

