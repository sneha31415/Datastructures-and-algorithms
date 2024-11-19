package org.example;

public class BinarySearch {
    public static int binarySearch(int arr[],int ele){
        int start =0;
        int end = (arr.length-1);
        while(start<=end){
           int mid = ((start+end)/2);
           if (arr[mid]>ele){
               end = mid-1;
           }
           else if(arr[mid]<ele){
               start = mid+1;
           }
           else {
                System.out.print(mid);
                return mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={2,3,4,5,6};
        binarySearch(arr,86);
        int index = binarySearch(arr,86);
        System.out.println(index);
    }
}
