package org.example.oops_learn;

//import static org.example.oops_learn.student.numStudents;

public class studentUse {
    public static void main(String[] args) {
        student s1= new student("sneha",24);
        System.out.println(s1);
        s1.print();
     s1.name="sneha singh";
       // s1.setroll(23);
        System.out.println(s1);
        System.out.println(s1.name);
        s1.getroll();
       // s1.setroll(12);
        s1.getroll();
        student s2 = new student(56);
/* buz numstudents is private so we cannot access it outside class
   System.out.println(s1.numStudents); */

        student.getnumstudents();
    }
}
