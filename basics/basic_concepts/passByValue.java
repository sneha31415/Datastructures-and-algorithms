package org.example;

public class passByValue {
    public static int updating(int n){
        n=n+1;
        return n;
    }

    public static void main(String[] args) {
        int n=10;
        int y= updating(n);
        System.out.println(y);
        updating(n);
        System.out.println(n);

    }
}
