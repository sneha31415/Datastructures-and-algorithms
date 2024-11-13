package org.example.oops_learn;

import java.sql.SQLOutput;

public abstract  class vehicle {
   private int maxspeed;
    protected  String color;
    //vehicle constructor
     public vehicle(String color){
        System.out.println("this is vehicle constructor");
    }
    public final void print(){
        System.out.println("maxspeed: "+ maxspeed);
        System.out.println(("color: "+color));
    }
    public abstract boolean isMotorised();
     public abstract String company();
    public void setMaxspeed(int s){
        maxspeed=s;
    }
    public int getMaxspeed(){
        return maxspeed;
    }
}
