package org.example;

public class MergeTwoSortedArrays {
public static int[] merge(int[]arr1,int[]arr2){
    int i=0;
    int j=0;
    int m=arr1.length;
    int n=arr2.length;
    int k=0;

    int arr[]=new int[m+n];

    while(i<m&&j<n){
        if(arr1[i]<=arr2[j]){
            arr[k]=arr1[i];
            i++;
            k++;
        }
        else{
            arr[k]=arr2[j];
            j++;
            k++;
        }
    }

    while(i<m){
        arr[k]=arr1[i];
        i++;
        k++;
    }
    while(j<n){
        arr[k]=arr2[j];
        j++;
        k++;
    }
    return arr;
}
public static void print(int[]arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
    }
}

    public static void main(String[] args) {
        int []arr1={4,6,7,8,9};
        int [] arr2={1,2,4,5,10,12,13};
        int []ans=merge(arr1,arr2);
        print(ans);
    }
}