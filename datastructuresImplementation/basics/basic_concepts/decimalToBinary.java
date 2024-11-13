package org.example;

public class decimalToBinary {
    public static void main(String[] args) {
        int n =5;
        String binary = "";
        while(n>0){
           binary = n%2 + binary;
           n=n/2;
        }
        System.out.println(binary);
    }
}
