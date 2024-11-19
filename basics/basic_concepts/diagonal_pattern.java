package org.example;
import java.util.Scanner;

public class diagonal_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int i1=1;
        int n = sc.nextInt();
        int n2= n/2;
        int n1= (n+1)/2;
        while(i1<=n){
            int s1=1;
            while(s1<=(n1-i1)){
                System.out.print(" ");
                s1++;
            }
            int j=1;
            while(j<=i1){
                System.out.print("*");
                j++;
            }
            int i2=1;
            int s2= 1;

        }
    }
}
