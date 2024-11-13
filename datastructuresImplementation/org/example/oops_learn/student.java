package org.example.oops_learn;

public class student {
    //properties of student
   public String name;
    private final  int roll;
    private static int numStudents;


    //getters and setters and printing are functionalities of student

     //we cannot use setter for roll no buz final data members cannot be initialized in any "functions"
    //    public void setroll(int rollno){
   //     roll = rollno;
     //     }
    public void getroll(){
        System.out.println(roll);
    }
    public void print(){
        System.out.println("the name is: "+ name);
        System.out.println(roll);
    }

    //custom constructors
    public student(String name , int roll){
        System.out.println(this);
        this.name = name;
        this.roll = roll;
        numStudents++;
    }

    public student(int r){
        roll =r;
        numStudents++;
    }

    // getter for numStudents
    public static int getnumstudents(){
        return numStudents;
    }
}
