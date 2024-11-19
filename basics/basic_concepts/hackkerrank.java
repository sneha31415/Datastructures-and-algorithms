package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class hackkerrank {
    public static void decrypt(StringBuilder s){
        s.reverse();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0'&& s.charAt(i)<='9'){
               s.setCharAt(i,' ');
              //  s.replace(i,i+1," ");
            }
        }
    }

    public static int coloured(int X,int Y,int x,int y){
        int leftRows = X-x;
        int leftCols = Y-y;
        int ans = (leftRows)*(leftCols);
        return ans;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        StringBuilder s= new StringBuilder("?worromot9loohcs8ot2gnimoC");
        decrypt(s);
        System.out.println(s);

        Scanner sc = new Scanner(System.in);
        System.out.println("enter X,Y,x.y");
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(coloured(X,Y,x,y));
    }
}
