package com.company;
import java.util.Random;

public class Complex {
    private Double dReal, dImagine;
    Random rand = new Random(500);

   public Complex(double real, double imagine) {
        this.dReal = real;
        this.dImagine = imagine;
    }
    public double getReal(){
        return this.dReal;
    }

    public double getImg(){
        return this.dImagine;
    }

    public void setReal(double val){
          this.dReal=val;
    }

    public void setImg(double val){
        this.dImagine=val;
    }

    public Complex(){
        this.dReal=rand.nextDouble();
        this.dImagine = rand.nextDouble();
    }

    public Complex addiction(Complex other) {
        this.dReal+=other.getReal();
        this.dImagine += other.getImg();
        return this;
    }

    public Complex multiplication(Complex number) {
        this.dReal = (this.dReal * number.getReal()) - (this.dImagine * number.getImg());
        dImagine = (this.dReal * number.getImg()) + (this.dImagine * number.getReal());;
        return this;
    }

    public double modulus() {
        return Math.sqrt(Math.pow(this.dReal, 2) + Math.pow(this.dImagine, 2)) ;
    }

    public double amplitude() {
        if (this.dReal > 0) {
            return Math.atan2(this.dImagine, this.dReal);
        } else if (this.dReal < 0 && this.dImagine > 0) {
            return Math.PI + Math.atan2(this.dImagine, this.dReal);
        } else {
            return  -Math.PI + Math.atan2(this.dImagine, this.dReal);
        }
    }
}
