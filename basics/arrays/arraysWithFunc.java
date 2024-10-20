package org.example;

public class arraysWithFunc {
    public static void print(int []arr){
        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void increment (int arr[]){
     //   arr=new int[5];
        System.out.println(arr);
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i]+1;
        }
    }

    public static void main(String[] args) {
        int[]demo={1,2,3,4,5};
        System.out.println(demo);
//        print(demo);
//        System.out.println();
        increment(demo);
        print(demo);
    }

}
