package org.example;

public class AWF {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    public static int[] increment(int input[]) {
        System.out.println(input);
        input = new int[8];
        System.out.println(input);
        for (int i = 0; i < input.length; i++) {
            input[i]++;
        }
        return input;
    }

    public static int[] change(int arr[]) {
        System.out.println(arr);
        arr = new int[7];
        arr[0] = 13;
        return arr;
    }

    public static void main(String[] args) {
//        int [] demo= {1,2,3,4,5};
//        System.out.println(demo);
//        demo = increment(demo);
//        System.out.println(demo);
//        print(demo);
        int[] ans = new int[5];
        ans = change(ans);
        System.out.println(ans);
        System.out.println(ans[0]);

    }
}
