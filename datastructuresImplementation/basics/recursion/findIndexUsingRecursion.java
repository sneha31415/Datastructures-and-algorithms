package org.example;

public class findIndexUsingRecursion {
    private static int lastIndex02(int input[], int key, int startIndex) {
        //base case
        if (startIndex == input.length) {
            return -1;
        }
        int smallAns= lastIndex02(input, key, startIndex + 1);
        if(smallAns!=-1){
            return smallAns;
        }

        if (input[startIndex] == key) {
            return startIndex;
        }
        else{
            return -1;
        }
    }
            public static int lastIndex02(int input[], int key){
            return lastIndex02(input, key, 0);
        }

    public static void main(String[] args) {
    int [] input ={9,1,2,4,5,9};
        System.out.println(lastIndex02(input,9));
    }

}
