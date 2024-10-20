package org.example;

public class sumOfArrayRecursio {
    public static int sumArray(int arr[]){
        //base casen
        //here base case in an array of zero elements
        if(arr.length<=0){
            return 0;
        }
        int smallArr [] = new int [arr.length-1];
        for(int i=1;i<arr.length;i++){
            smallArr[i-1]=arr[i];
        }
         int smallAns = sumArray(smallArr);
        return arr[0]+smallAns;
    }
    public static int sum(int input[],int startindex){
        if(startindex == input.length){
            return 0;
        }
        return input[startindex]+sum(input,startindex+1);
    }

    public static void main(String[] args) {
        int array[]={1,2,3,4,5};
        System.out.println(sumArray(array));
        System.out.println(sum(array,0));

    }
}
