package org.example;

public class selectionSort {
public static void printarr(int[]arr){
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
}
public static void selectionSort(int arr[]){
    for (int i=0;i<arr.length-1;i++){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for(int j=i;j<arr.length;j++){
            if(arr[j]<min){
                min = arr[j];
                minIndex=j;
            }
        }
        int temp = arr[minIndex];
        arr[minIndex]=arr[i];
        arr[i] = temp;
    }
}

    public static void main(String[] args) {
        int []array = {2,1,7,4,5,3};
        selectionSort(array);
        printarr(array);
    }
}
