package com.company;


public class Compmatrix {

    private Integer i,j,k;
    private Integer[] [] [] matrix;
    private Integer[] [] [] result;
    public Compmatrix(Integer[] [] [] a){
        this.matrix= a.clone();
        this.result=a.clone();
    }

    public void add(Compmatrix a){
        for (k=0;k<matrix.length;k++){
            for(i=0;i<matrix[0].length;i++){
                for (j=0;j<matrix[0][0].length;j++){
                    result[k][i][j]=matrix[k][i][j]+a.matrix[k][i][j];
                }
            }
        }
    }

    public void sub(Compmatrix a){
        for (k=0;k<matrix.length;k++){
            for(i=0;i<matrix[0].length;i++){
                for (j=0;j<matrix[0][0].length;j++){
                    result[k][i][j]=matrix[k][i][j]-a.matrix[k][i][j];
                }
            }
        }
    }

    public void show(){
        for (j=0;j<result[0][0].length;j++){/////////////k=0;k<result.length;k++){
            for(i=0;i<result[0].length;i++){
                for (k=0;k<result.length;k++ ){/////////j=0;j<result[0][0].length;j++){
                    //result[k][i][j]=matrix[k][i][j]-a.matrix[k][i][j];
                    if(k==1){
                        System.out.print(result[k][i][j]+"i\n");
                    }else {
                        System.out.print(""+result[k][i][j]+"+");
                    }

                }
            }
        }
    }
    }


