package org.example;

public class palindrome {
    public static boolean checkPalindrome(String str){
        int n=str.length();
        int j=n-1;
        int i=0;
            while(i<=(n/2)-1){
                if(str.charAt(i)!=str.charAt(j)){
                    return false;
                }
                else{
                    i++;
                    j--;
                }
            }

        return true;
    }

    public static void main(String[] args) {
        String demo="acbhcca";
        System.out.println(checkPalindrome(demo));
    }
}
