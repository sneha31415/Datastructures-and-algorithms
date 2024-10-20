package org.example;

import java.util.Scanner;

public class f1f2 {
    public static int factorial(int n){
        int mul=1;
        for (int i=1;i<=n;i++){
            mul= mul*i;
        }
        return mul;
    }
    public static int nCr(int n,int r){
        int num= factorial(n);
        int den1= factorial(r);
        int den2= factorial(n-r);
        int ans = (num/(den2*den1));
        return ans;
    }

    public static boolean isPrime(int n){
        for (int i =2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void PrintPrime(int n){
        for (int p=2; p<=n; p++){
            boolean isIPrime = isPrime(p);
            if(isIPrime){
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n= sc.nextInt();
       int r = sc.nextInt();
       int Answer= nCr(n,r);
        System.out.println(Answer);
        PrintPrime(100);

    }
}
