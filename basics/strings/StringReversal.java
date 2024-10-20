package org.example;
import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "snehasingh221";
        char ch[] = s.toCharArray();
        String reverse ="";
        for(int i=0;i<ch.length;i++){
            reverse = ch + reverse;
            //System.out.println(reverse);
        }
        char[] reverse2= reverse.toCharArray();
        for(int i=0;i<reverse2.length;i++){
            System.out.print(reverse2[i]);
        }
    }

}
