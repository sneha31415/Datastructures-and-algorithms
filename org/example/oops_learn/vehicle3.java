package org.example.oops_learn;

public class vehicle3 implements print_interface{
    private int maxspeed;
    protected  String color;
    //vehicle constructor
    public vehicle3(String color){
//        System.out.println("this is vehicle constructor");
    }
    public /*final*/ void print(){
      //  System.out.println("maxspeed: "+ maxspeed);
        System.out.print(("color: "+color));
}
    }