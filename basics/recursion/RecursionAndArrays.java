package org.example;

public class RecursionAndArrays {
    //IMPORTANT
    //sorting arrays
    public static boolean sortArrays(int arr[]){
        //base case
        if(arr.length<=1){
            return true;
        }
        //solve smaller problem
        int smallInput []= new int [arr.length -1];
        for(int i=1;i<arr.length;i++){
           smallInput[i-1]=arr[i];
        }
        boolean smallAns = sortArrays(smallInput);
        if (!smallAns){
            return false;
        }
        if(arr[0]<=arr[1]){
            return true;
        }
        else {
            return false;
        }
    }
    //better approach //important
    private static boolean checkSort(int input[],int startIndex){
            //base case
        if(startIndex==input.length-1){
            return true;
        }
        if(input[startIndex]>=input[startIndex+1]){
            return false;
        }
        //recursive step
        return checkSort(input,startIndex+1);
    }
    //new function making so that the user doesnot need to know what start index is
    public static boolean checkSort(int []input){
        return checkSort(input,0);
    }

    //problem 2. check whether the number given is present in the array and find its LEAST index
    private static int checkElement(int []input,int x,int startIndex){
        //base case
        if(startIndex==input.length){
            return -1;
        }
        if(input[startIndex]==x){
            return startIndex;
        }
        return checkElement(input,x,startIndex+1);
    }
    public static int checkElement (int []input,int x){
        return checkElement(input,x,0);

    }

    //find the last index of an array element, if not present then return -1
    private static int lastIndex (int input[],int x, int lastIndex){
        //base case
        if(lastIndex<0){
            return -1;
        }
        if(input[lastIndex]==x){
            return lastIndex;
        }
        //recursive call
        return lastIndex(input,x,lastIndex-1);
    }
    public static int lastIndex(int input[],int x){
        return lastIndex(input,x,input.length-1);
    }

    //by startindex we will find the  last index of key
    // to do this, just perform step 3 first and then step 2


    public static void main(String[] args) {
        int input01[] = {0,3,5,7,9,8,8,7,3,3};
        System.out.println(sortArrays(input01));
        System.out.println(checkSort(input01));
        System.out.println(checkElement(input01,3));
        System.out.println(lastIndex(input01,3));
//        System.out.println(lastIndex02(input01,3));
    }

}
