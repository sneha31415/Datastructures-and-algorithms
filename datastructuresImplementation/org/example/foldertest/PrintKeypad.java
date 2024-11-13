package org.example.foldertest;

public class PrintKeypad {
    public static String helper (int n){
        if(n<0 || n>10){
            System.exit(0);
        }
        if(n==2){
            String output="abc";
            return output;
        }
        else if(n==3){
            String output="def";
            return output;
        }
        else if(n==4){
            String output="ghi";
            return output;
        }
        else {
            String output ="jkl";
            return output;
        }
    }
    public static void printKeypad(int n,String output){
        //base case
        if(n==0){
            System.out.println(output);
       // System.exit(0); mat karna kyuki fir first time pe n==0 hone pe hi program band ho jaega i.e only ad will be printed (first time jab n==0 hoga tab output mei "ad" hoga aur uske baad program band ho jaega cuz of system.exit 
            return;
        }

        String small = helper(n%10);
        for(int i=0;i<small.length();i++) {
            printKeypad(n / 10, small.charAt(i) + output);
        }
    }
    public static void printKeypad(int n){
        printKeypad(n," ");
    }

    public static void main(String[] args) {
        int n = 23;
        printKeypad(n);
    }
}

