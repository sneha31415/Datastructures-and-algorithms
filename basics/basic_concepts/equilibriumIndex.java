package org.example;

public class equilibriumIndex {
    public static int Equilibrium(int arr[]){
        int sum1=0;
        int sum2=0;
        int index = -1;
        for(int i =0;i<arr.length;i++){
            for(int j=i;j< arr.length-1;j++){
                sum1= sum1+ arr[i];
                sum2= sum2+ arr[j+1];
                if(sum1==sum2){
                   index = i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int []arr = {4,5,6,9,0};
        int ans = Equilibrium(arr);
        System.out.println(ans);
    }
}
