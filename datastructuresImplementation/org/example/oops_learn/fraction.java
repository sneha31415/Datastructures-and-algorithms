package org.example.oops_learn;

public class fraction {
 private int num;
 private int den;

 //making constructor
 public fraction(int num,int den) throws zeroDenominatorException {
     this.num = num;
     if(den==0){
         zeroDenominatorException e= new zeroDenominatorException();
         throw e;
     }
     this.den = den;

     simplify();
 }
 //simplify function is needed only by this class so only this class should be able to access it so it is private
 private void simplify(){
     for(int i=(Math.min(num,den));i>1;i--){
         if(num%i==0 && den%i==0){
             this.num = num/i;
             this.den = den/i;
             return;
         }
     }
 }
 public void print(){
     if(this.den==1){
         System.out.println(num);
     }
     if(this.num==0){
         System.out.println(num);
     }
    else{ System.out.println(num+"/"+den);
    }}
 public void setdenominator(int den) throws zeroDenominatorException {
     if (den == 0) {
        /* Exception e = new Exception("dr. cant be zero");
         throw e*/ // or-->
         zeroDenominatorException e = new zeroDenominatorException(); //ab koio string message ki bhi jarvat nahi
         throw e;
     } else {
         this.den = den;
         simplify();
     }
 }
// public void getdenominator(){
//     System.out.println(this.den);
// }
// or way of getter==
    public int getdenominator(){
     return den;
    }
 public void setnumerator(int num){
     this.num = num;
     simplify();
 }
 public int getnumerator(){
     return num;
 }
 public void add(fraction f2){
     this.num = (this.num*f2.den)+(this.den*f2.num);
     this.den = (f2.den*this.den);
     //this denotes the one jispe call hui eg,=.f1.add(f2) yah pe f1 pe call hui
     simplify();
 }
 public void multiply(fraction f2){
     this.num = this.num*f2.num;
     this.den = this.den*f2.den;
     simplify();
 }
// public void add(fraction f1, fraction f2){
//     this.num = (f1.num*f2.den)+(f2.num*f1.den);
//     this.den =f1.den*f2.den;
//     simplify();
// }
    //better way of f3 = f1+f2
    public static fraction add(fraction f1, fraction f2) throws zeroDenominatorException {
     int newnum = f1.num*f2.den+ f2.num*f1.den;
     int newden = f1.den*f2.den;
     //bcuz we have created fraction object in this function so, it can throw a zeroDenominatorException so, in this func we have to write "throws ZDE" buz this function will either handle the exception given by f3 or throw it
     fraction f3 = new fraction(newnum,newden);
     return f3;

    }

}
