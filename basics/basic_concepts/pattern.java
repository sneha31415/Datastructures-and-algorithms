package org.example;
import java.util.Scanner;

public class pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while (i <= n) {
            int space = 1;
            while (space <= (n - i)) {
                System.out.print(" ");
                space++;
            }
            int j=1;
            while(j<=i){
                System.out.print(j);
                j++;
            }
            i++;
            System.out.println();
        }
    }
}