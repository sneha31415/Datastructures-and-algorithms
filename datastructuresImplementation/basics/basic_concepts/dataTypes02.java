package org.example;

public class dataTypes02 {
    public static int sum(int[]arr){
        int sum =0;
        for(int i=0;i<5;i++){
            sum=sum+arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int array[]={2,4,3,5,6,8,9};
        int ans = sum(array);
        System.out.println(ans);
        System.out.println(sum(array));
    }
}
