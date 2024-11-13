package org.example;

public class recursion1Assignments {
    //Given two integers M & N, calculate and return their multiplication using recursion. You can only use subtraction and addition for your calculation
    public static int multiplication(int m,int n){
        //base case
        //m==0 bhi check kiya bcuz if m hi zero hai to aage kyu hi check karna.. so it is waste of time complexity
        if(n==0||m==0){
            return 0;
        }
        return multiplication(m,n-1)+m;
    }

    public static int numberOfZeroes(int number [],int startIndex){
        //base case
        int smallAns=0;
        if(startIndex==number.length){
            smallAns=-1;
            return smallAns;
        }
        if (number[startIndex]==0){
            smallAns++;
        }
        smallAns = numberOfZeroes(number,startIndex+1);
        return smallAns;
    }


    //couldnt do
    public static int zeroes(int n){
        //base case
        int smallAns=0;
        if(n==0){
            return smallAns;
        }

        if(n%10==0){
            smallAns++; //do not return now
        }

        return smallAns;
    }

    //problem 3
    //geometric sum
    public static double geometricSum(int k){
        if(k==0){
            return 1.0;
        }
        double smallAns =  geometricSum(k-1);
        return smallAns+(1/Math.pow(2.0,k));
    }

    //problem 4
    //palindrome
    public static boolean checkPalindrome(String s,int startIndex, int endIndex){
        //base case
        int n =s.length();
        if(startIndex==(n+1)/2 ||endIndex==(n)/2){
            return true;
        }
        if(s.charAt(startIndex)!=s.charAt(endIndex)){
            return false;
        }
        return checkPalindrome(s,startIndex+1,endIndex-1);
    }

    public static void main(String[] args) {
//        System.out.println(multiplication(21,111));
//        int array []={0,1,3,5,0,0};
//        System.out.println(numberOfZeroes(array,0));
//        System.out.println(zeroes(22004));
      //  System.out.println(geometricSum(1));
        String s="abcba";
        System.out.println(checkPalindrome(s,0,s.length()-1));
    }

}
