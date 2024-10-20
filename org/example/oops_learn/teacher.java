package org.example.oops_learn;

public class teacher implements print_interface{
    private int id;
    public teacher(int id){
        this.id= id;
    }
    public void print(){
        System.out.print("id: "+id);
    }
}
