package org.example;

public class printAllSubstrings{
    public static void printAllSubstrings(String str){
        int n = str.length();
        for(int i=0;i<n;i++){
            for(int end=i;end<n ;end++){
                System.out.print(str.substring(i,end+1)+" ");
            }
        }
    }
    public static void main(String[] args) {
        String str="abcd";
        printAllSubstrings(str);

    }
}
