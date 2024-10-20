package org.example.oops_learn;

public abstract class car extends vehicle{
    int numGears;
    boolean isConvertible;
    public car(){
        super("black"); //now vehicle constructor will have no problem
        System.out.println("this is car constructor");
    }

//    @Override
//    public boolean isMotorized() {
//        return false;
//    }

    @Override
    public boolean isMotorised(){
        return true;
    }
       public void printcar (){
       // System.out.println("maxspeed: "+maxspeed); //maxspeed is not accessible
        //System.out.println("color: "+color); //instead do super.print();

        super.print();
        System.out.println("numgears: "+ numGears);
        System.out.println("isconvertible: "+isConvertible);
           System.out.println("isMotorised: "+ isMotorised());
    }

}
