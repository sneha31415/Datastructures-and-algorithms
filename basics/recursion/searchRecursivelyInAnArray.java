package org.example;

public class searchRecursivelyInAnArray {
    //do not use this approach of solving, instead use pointers
    public static boolean search (int input[],int n){
        //base case
        if(input.length==0){
            return false;
        }
        //pehle step3 kara
        if(input[0]==n){
            return true;
        }
        //smaller problem i.e step2
        int smallInput[]= new int [input.length-1];
        for(int i=1;i<input.length;i++){
            smallInput [i-1] = input[i];
        }

       boolean smallAns = search(smallInput,n);
        return smallAns;
    }

    //better approach
    public static boolean searching (int arr[],int key,int startIndex){
        //base case
        //never smaller the array the array size
        //instead always use pointer to (here int startIndex is the pointer) go ahead or back in an array
        if(startIndex==arr.length){
            return false;
        }
        if(arr[startIndex]==key){
            return true;
        }
        //recursive call on the smaller problem
        return searching(arr,key,startIndex+1);
    }
        //searching  from end to start
    public static boolean searching02(int arr[],int key,int endIndex){
        if (endIndex==-1){
            return false;
        }
        if(arr[endIndex ]==key){
            return true;
        }
        return searching02(arr,key,endIndex-1);
    }

    public static void main(String[] args) {
        int input[] = {1,2,3,4,5,6,7,8,9,9};
        //System.out.println(search(input,22));
        System.out.println(searching02(input,1,input.length-1));
        System.out.println(searching(input,1,0));

    }
}
