package org.example.oops_learn;

public class dynamicArrayClasssUse {
    public static void main(String[] args) {
        dynamicArray d1 = new dynamicArray();
        System.out.println(d1.isEmpty());
        //we can add only one element at a time or run a for loop for d1.add()
        d1.add(3);
        System.out.println(d1.isEmpty());
    }

}
