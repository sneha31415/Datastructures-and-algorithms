package org.example.oops_learn;
//we can implement multiple interfaces
//but cannot extend multiple classes(i.e multiple inheritance not allowed)

//here we are extending as well as implementing
public class truck2 extends vehicle2 implements interface_learn,truck_interface{
    public int numTyres(){
        return 4;
    }
    public int maxspeed(){
        return 90;
    }
    public int maxLoad(){
        return 40;
    }

}
