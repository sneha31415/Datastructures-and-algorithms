package org.example;

public class StringsImmute {
    public static void main(String[] args) {
        String str = "abc";
       // str.setCharAt(2) = 'd';
        str = str + "def";
        System.out.println(str);
        str = "xyz";
        System.out.println(str );
    }
}