package C2_linkedList;

import java.util.ArrayList;

public class C3_RemoveConsecutiveDuplicates {
    //becz we do not know the number of duplicates, so the return type of the func is arrayList
    public static ArrayList<Integer> remove(int arr []){
        ArrayList<Integer> output = new ArrayList<>();
        //first add the first element
        //output.add(0,arr[0]);

        for(int i =0;i<arr.length-1;i++){
            if(arr[i]!=arr[i+1]){
                output.add(arr[i]);
            }
        }
        output.add(arr[arr.length-1]);
        return output;
    }

    public static void main(String[] args) {
            int arr[] = {1,1,2,2,3,4,5,5,5,7,7,8};
         ArrayList<Integer> output = new ArrayList<Integer>();
           output = remove(arr);

           //printing the result
            for(int i : output){
                System.out.print(i+" ");
            }

    }

}
