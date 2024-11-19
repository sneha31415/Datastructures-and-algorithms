package org.example;

import java.util.Scanner;

public class Scope_of_variable {
    public static int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * i;
        }
        return ans;
    }

    public static boolean isprime(int n) {
      for(int d=2;d<n;d++){
          if (n%d==0){
              return false;
          }
      }
      return true;
    }

    public static void func(int x, int y){
        //...........
        System.out.println("frjferkfuerf");
        return ;
    }

    public static void numbers(int n){
        if (n<0){
            return;
        }
        for(int i =1; i<=n; i++){
            System.out.println(i);
        }
    }

   public static void convert(int start,int end,int gap){
      for (int c = start; c<=end; c=c+gap){
           int fah = (int)((5.0/9)*(c-32));
          System.out.println(fah);
      }
    }

    public static void main(String[] args) {
        convert(20,400,10);


    }
}

