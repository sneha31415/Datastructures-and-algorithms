package org.example.oops_learn;

public class generics_for_methods {
    //print
    public static <T> void printArray(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
   // public static <T extends vehicle3> void print_Array(T arr[]) {
        public static <T extends print_interface > void print_Array(T arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i].print();
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer arr[] = {1, 2, 3, 5, 3, 7, 20, 10};
        printArray(arr);

        String str[] = new String[10];
        for (int i = 0; i < str.length; i++) {
            str[i] = "abc";
        }
        printArray(str);
        //so, printArray() method is working for both the datatypes

        //BOUND GENERIC TYPE3
        vehicle3 v[] = new vehicle3[10];
        for (int i = 0; i < v.length ; i++) {
            v[i] = new vehicle3("black");
        }
        //this will print address
        printArray(v);
        print_Array(v);

        teacher t[] = new teacher[5];
        for(int i=0;i< t.length;i++){
            t[i] = new teacher(i+1);
        }
        print_Array(t);
    }
}

