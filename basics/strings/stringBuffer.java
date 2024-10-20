package org.example;

public class stringBuffer {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < 5; i++) {
            str.append((char) ('a' + i));
            System.out.println(str);
        }
        System.out.println(str);

        int arr[] = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i]='a'+i;

        }
    }
}