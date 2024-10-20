package org.example;

public class printAllPairs {
    // public static void printallpairs(int arr []) {
//        for (int i = 0; i < (arr.length - 1); i++) {
//            int j = i+1;
//            if (i < j) {
//                j++;
//            }
//        }
//    }
    public static void print(int[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")"+" ");
            }
        }
    }

    public static void swap(int arr[]){
      for(int i=0;i<arr.length-1;i=i+2){
          int temp= arr[i];
          arr[i]=arr[i+1];
          arr[i+1]= temp;
      }
    }
    public static void printF (int[]arr){
   for(int i=0;i<arr.length;i++){
       System.out.print(arr[i]+" ");
   }
    }

    public static void main(String[] args) {
        int demo[]= {1,2,3,4,5};
       // print(demo);
        swap(demo);
        printF(demo);

    }

}