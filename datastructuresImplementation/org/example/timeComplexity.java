package org.example;

import java.util.Arrays;

public class timeComplexity {
    public static void intersectionOfArray(int arr1[],int arr2[]){
     Arrays.sort(arr1); //m*log(m) work done
     Arrays.sort(arr2); //n*log(n) work done
     int m = arr1.length;
     int n = arr2.length;
     int i = 0;
     int j = 0;
     while (i<m && j<n){
         if(arr1[i]==arr2[j]){
             System.out.println(arr1[i]+" ");
             j++;
             i++;
         } else if (arr1[i] > arr2[j]) {
             j++;
         }
         else{
             i++;
         }
     }
    }

    public static void main(String[] args) {
        int arr1[]= {2,3,4,5,0,1};
        int arr2[] = {9,21,13,7,0,3};
     intersectionOfArray(arr1,arr2);

    }
}
