package org.example.newPackage;

import org.example.oops_learn.vehicle;
public class truck extends vehicle {
   int maxloading;
   public truck(){
       super("black");
   }
   @Override
   public boolean isMotorised(){
       return false;
   }
   public String company(){
       return "jcb";
   }
   public void printtruck(){
       super.print();
       System.out.println("maxloading: " + maxloading);
       System.out.println("truckspeed: "+ getMaxspeed());
       System.out.println("truckcolor: "+color); //color is now accessible bcuz its protected

   }
}
