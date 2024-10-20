package org.example;

import java.lang.management.MonitorInfo;
import java.util.Scanner;

public class funcWith2DArrays {
    public static int [][] input(){
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int cols = s.nextInt();
        int arr[][] = new int[rows][cols];

        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                 arr[i][j]= s.nextInt();
            }
        }
        return arr;
    }
    public static void print(int arr[][]){
      int cols= arr[0].length;
      int rows = arr.length;
      for (int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
              System.out.print(arr[i][j] + " ");
          }
          System.out.println();
      }
    }
    public static int largestColumnSum(int arr[][]){
        int rows= arr.length;
        int cols= arr[0].length;
        int largest = Integer.MIN_VALUE;
        for(int j=0;j<cols;j++){
            int sum =0;
            for(int i=0;i<rows;i++){
                sum = sum + arr[i][j];
            }
            if (sum>largest){
                largest = sum;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
       int demo[][] = input();
       print(demo);
        int ans = largestColumnSum(demo);
        System.out.println(ans);
    }
}
