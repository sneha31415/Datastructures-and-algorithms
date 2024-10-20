package org.example;

public class reverseString {
//    public static String reverse(String str){
//        for(int i=0;i<str.length();i++){
//           String reverse=" ";
//            int n = str.length();
//           String reverse= str.charAt(n-i-1);
//            return reverse;
//        }
//    }
    public static String reverse (String str){
        String reverse = "";
        int n =str.length();
        for(int i=0;i<n;i++){
          //  reverse =(String) str.charAt(n-i-1);
            reverse=str.charAt(i)+reverse;

        }
        return reverse;
    }

    public static void main(String[] args) {
     String str = "abcde";
     String ans = reverse(str);
        System.out.println(ans);
    }
}
