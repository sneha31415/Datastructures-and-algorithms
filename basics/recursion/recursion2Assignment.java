package org.example;

public class recursion2Assignment {
   //Replace all "pi" with 3.14
    //to solve this we should not use character array buz we are replacing pi(2 characters) WITH 3.14(4 characters) so size of character array needs to be changed each time
    //similarly we shuld use output string and not use the same input string because size of input string needs to be changed then
    //problem 1
    public static String replace(String input){
        //base case
        String output;
        if(input.length()<=1){
            return input;
        }
        String small = replace(input.substring(1));
        if(small.charAt(0)=='i' && input.charAt(0)=='p' ){
            output= "3.14"+ small.substring(1);
        }
        else {
            output = input.charAt(0)+small;
        }
        return output;
    }

    //problem 2 **remove X
    public static String removeX(String s){
        String output = "";
        //base case
        if(s.length()<=0){
            return s;
        }
        String small = removeX(s.substring(1));
        if(s.charAt(0)=='x'){
           output = small;
        }
        else {
            output = s.charAt(0)+small;
        }
        return output;
    }

    //problem 3 **string to int
    public static int convert(String s){
        //base case
        if(s.length()<=1){
            return s.charAt(0)-'0';
        }
        int a = convert(s.substring(0,s.length()-1));
        int b = s.charAt(s.length()-1)-'0';
        int ans = (a*10)+b;
        return ans;
    }
    //approach 2
    public static int convert1(String s){
        //base case
        if(s.length()<=1){
            return s.charAt(0)-'0';
        }
        int a = convert1(s.substring(1,s.length()));
        int b = s.charAt(0)-'0';
        int ans = (int) (b*(Math.pow(10,s.length()-1)) + a);
        return ans;
    }
    public static String putStar(String s){
        //String ans = "";
        //base case
        if (s.length()<=1){
            return s;
        }
        String ans = putStar(s.substring(1));
        if(s.charAt(0)==ans.charAt(0)){
            ans=  s.charAt(0) +"*" + ans.charAt(0)+ans.substring(1);
        }
        else {
            ans= s.charAt(0) + ans;
        }
        return ans;
         }
         public static void towerofHanoi(int disks, char source, char aux, char dest){
        if (disks == 0){
            return;
        }
             towerofHanoi(disks-1,source,dest,aux);
             System.out.println(source+ "-->"+ dest);
             towerofHanoi(disks-1,aux,source, dest);
         }




    public static void main(String[] args) {
        String s = "pihxxpiss";
//        System.out.println(replace(s));
//        System.out.println(removeX(s));
        String a = "12345";
//        System.out.println(convert(a));
//        System.out.println(convert1(a));
        System.out.println(putStar(s));
        towerofHanoi(3,'s','a','d');


    }
}