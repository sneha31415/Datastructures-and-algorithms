package org.example;

public class largestSumCol {
public static void largestRC (int arr[][]){
    int rows = arr.length;
    int cols = arr[0].length;
    int index = -1;
    int largest = Integer.MIN_VALUE;
    boolean isRow = true;

    for(int i=0;i<rows;i++){
        int sum = 0;
        for(int j=0;j<cols;j++){
            sum = sum + arr[i][j];

        }
        if(sum>largest){
            largest = sum;
            index = i;
        }
    }
    // sum calculations for cols
    for(int j=0;j<cols;j++){
        int sum = 0;
        for(int i=0;i<rows;i++){
            sum = sum + arr[i][j];
        }
        if(largest<sum){
            isRow = false;
            largest = sum;
        }
    }
     if(isRow){
         System.out.println("row");
     }
     else{
         System.out.println("cols");
     }
    System.out.println(index);
    System.out.println(largest);
}

    public static void main(String[] args) {
        int arr[][] = {{10,3,6},{9,0,4},{9,0,7}};
        largestRC(arr);
    }
}
