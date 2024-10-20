package org.example.oops_learn;

public class complexNumber {
    private int real;
    private int imag;
    public complexNumber(int real,int imag){
        this.imag= imag;
        this.real= real;
    }
    public int getImaginary(){
        return imag;
    }
    public int getReal(){
        return real;
    }
    public void setReal(int real){
        this.real = real;
    }
    public void setimaginary(int imag){
        this.imag = imag;
    }
    public void print(){
        System.out.println(real+"+"+imag+"i");
    }
    public void add(complexNumber c){
        this.imag= this.imag+c.getImaginary();
        this.real= this.real+c.getReal();
    }
    //not working
    public void multiply(complexNumber c){
        this.real = (this.real * c.real)-(this.imag * c.imag);
        this.imag =(this.real*c.imag)+ (this.imag *c.real);
    }
    public complexNumber conjugate(){
        int newreal = real;
        int newimag = -imag;
        complexNumber ans = new complexNumber(newreal,newimag);
        return ans;
    }
    public static complexNumber add(complexNumber c1, complexNumber c2){
        int newreal = c1.getReal()+c2.getReal();
        int newimag = c2.getImaginary()+c1.getImaginary();
        complexNumber ans = new complexNumber(newreal,newimag);
        return ans;
    }
}
