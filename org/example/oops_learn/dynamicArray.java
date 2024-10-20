package org.example.oops_learn;

public class dynamicArray {
    private int data[];
    private int nextIndex ;
    //making of constructor to create a dynamic array
    public dynamicArray(){
        data = new int[5]; //bydefault an array of size 5 is created
        nextIndex=0;
    }

    //func to add element at the just nextIndex
    public void add(int element){
        if(nextIndex == data.length){
            restructure();
        }
        data[nextIndex]=element;
    }

    public void set(int index,int element){
        if(index>nextIndex){
            return; //we can only add an element upto nextIndex cuz after that spaces will be left in betwen
        }
        else if(index<nextIndex){
            data[index]=element;
        }
        else{
            add(element);
        }
    }
    public int get(int index){
        return data[index];
    }
    public boolean isEmpty(){
        //if data.length ==0 is true , the return true hoga so (data.length==0) ka true ya false will be returned
       return data.length == 0;
//        boolean b = data[0] == null;
//        return b;
    }

    private void restructure(){
        //we are just declaring temp and not making it , as array is made by "new" word
        int temp[] = data;  //doubt
        data = new int[2* data.length];
        for(int i=0;i< temp.length;i++){
            data[i]=temp[i];
        }

        //this is also correct but there is unnecessary creation of temp[] array
//        int temp[] = new int[data.length];
//        for(int i=0;i< temp.length;i++){
//            temp[i]=data[i];
//        }
//        data = new int[2* data.length];
//        for(int i=0;i< temp.length;i++){
//            data[i]=temp[i];
//        }
    }

    public int size(){
        return nextIndex;
    }

    public int removeLast(){
        if(size()==0){
            //error out
            return -1;
        }
        int value = data[nextIndex];
        value =0; //if we want to use this index now then use add() func
        nextIndex--;
        return value;
    }

}
