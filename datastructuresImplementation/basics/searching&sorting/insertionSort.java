package org.example;

public class insertionSort {
    public static void selectionSort(int[]arr){
        int n =arr.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            int temp=arr[i];
            while(j>=0&&arr[j]>temp){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
    public static void print(int[]arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int demo[]={1,9,5,3,4,9,0,5,-4};
        selectionSort(demo);
        print(demo);

    }

}
