package org.example.oops_learn;

public class finalForClassesAndFunctions {
    public final void show() {
        System.out.println("show of base");
    }

    class derived extends finalForClassesAndFunctions {

        //bcuz show() in base class is final so here we cannot make show() func in derived class
//        public void show() {
//            System.out.println("show");
//        }
    }
    public class solution{
        public void main(String[] args) {
           finalForClassesAndFunctions d = new derived();
        }
    }
}