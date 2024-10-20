package org.example;

public class equilibriumCorrect {
    public static int equi(int arr[]) {
        int index = 0;
        for (int i = 0; i < arr.length;i++) {
            int totalSum = 0;
            int rightSum = 0;
            totalSum = totalSum + arr[i];
            int leftSum = 0;

            while (index < arr.length) {
                leftSum += arr[i];
                rightSum = totalSum - leftSum - arr[i];

                if (leftSum == rightSum) {
                    return index;
                } else {
                   // leftSum = leftSum + arr[i];
                    index++;
                }
            }
        }
        return -1 ;
    }
    public static int equilibrium(int arr[]){
        int total = 0;
        int leftsum=0;
        int rightsum=0;
        int index=0;
        for(int i=0;i<arr.length;i++){
            total += arr[i];
        }

        while(index<arr.length){
            leftsum += arr[index];
            rightsum += total-leftsum-arr[index];
            if(leftsum==rightsum){
                return index;
            }
            else {
                index++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,8,1,3,2,9};
        int ans =equilibrium(arr);
        System.out.println(ans);
    }
}