package org.example;

public class recursion {
    //calculation of factorial
    public static int fact(int n){
        if(n==0){
         return 1;
        }
        int smallAns= fact(n-1);
        return smallAns*n;
    }
    //addition of 1 to n numbers
    public static int sum(int n){
        if(n==1){
            return 1;
        }
        int smallAns = sum(n-1);
        return smallAns+n;
    }
    //power of a number
    public static int power(int x,int n){
        if(n==0){
            return 1;
        }
        return (power(x,n-1))*x;
    }
     //count number of digits
    public static int count(int n){
        if(n==5){
            return 1;
        }
       int SmallAns = count(n/10);
        return SmallAns+1;
     }

     //fibbonacci series
    public static int fib(int n) {
        if (n == 1 || n==0){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    public static void main(String[] args) {
        int n=5;
//        int ans = fact(n);
//        int ans2= sum(n);

//        int ans = power(2,9);
//        System.out.println(ans);

//        System.out.println(ans);
//        System.out.println(ans2);

     //   System.out.println(fib(6));

    }

}
