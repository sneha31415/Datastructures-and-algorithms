package org.example;

public class String_comparison {
    public static void main(String[] args) {
        int arr1[]={1,2};
        int arr2[]={1,2};
        String str1= "sneha";
        String str2 =new String ("sneha");
        if(str1.equals(str2)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
        if(arr1.equals(arr2)){
            System.out.println("they are equal");
        }
        else{
            System.out.println("they are not equal");
        }
    }
}
