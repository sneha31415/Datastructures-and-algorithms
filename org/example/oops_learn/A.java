package org.example.oops_learn;
//problems for practice
public abstract class A{
    int i;
    abstract void display();
}
class B extends A{
    public int j;
    void display(){
        System.out.println(j);
    }
}
class Main{
    public static void main(String[] args) {
        B obj= new B();
        obj.j=2;
        obj.display();
    }
}
