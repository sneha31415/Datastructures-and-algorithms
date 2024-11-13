package org.example;

public class recursion2 {
    public static String removeX(String s) {
        //base case
        if (s.length() == 0) {
            return "";
        }
        String ans = "";
        if (s.charAt(0) != 'x') {
            ans = ans + s.charAt(0);
        }
        return ans + removeX(s.substring(1));
    }

    public static String replaceCharacterRecursively(String s, char c1, char c2) {
        //base case
        if (s.length() == 0) {
            return s;
        }
        char c;
        if (s.charAt(0) == c1) {
            c = c2;
        } else {
            c = s.charAt(0);
        }
        String ans = replaceCharacterRecursively(s.substring(1), c1, c2);
        return (c + ans);
    }

    public static String removeDuplicates(String s) {
        if (s.length() <= 1) {
            return s;
        }
        if (s.charAt(0) == s.charAt(1)) {
            return removeDuplicates(s.substring(1));
        } else {
            return s.charAt(0) + removeDuplicates(s.substring(1));
        }
    }

    //tough problem
    public static void mergeSort(int input[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        int mid = (si + ei) / 2;
        mergeSort(input, si, mid);
        mergeSort(input, mid + 1, ei);
        merge(input, si, ei);

//        if(input[0]>input[1]){
//            int temp= input[0];
//            input[0]=input[1];
//            input[1]= temp;
//        }
    }

    public static void merge(int input[], int si, int ei) {
        int[] result = new int[ei - si + 1];
        int mid = (si + ei) / 2;
        int i = si;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= ei) {
            if (input[i] <= input[j]) {
                result[k] = input[i];
                i++;
                k++;
            } else {
                result[k] = input[j];
                j++;
                k++;
            }
        }
        while (i <= mid) {
            result[k] = input[i];
            i++;
            k++;
        }
        while (j <= ei) {
            result[k] = input[j];
            j++;
            k++;
        }

//this is wrong way
//        for (i = 0; i < input.length; i++)
//            for (j = 0; i < result.length; j++) {
//                 input[i]=result [j];
//            }
        for (int index = 0; index < result.length; index++) {
            input[si + index] = result[index];
        }
    }

    public static void print(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static int partition(int input[], int si, int ei) {
        //you should assign no index as 0 or any constant value.
        //assign it values like si or ei, etc. buz on recursive call the array gets smaller and thus the si and ei of each array is different ans not always 0 ans (arr.length-1)
        int pivot = input[si];
        int count = 0;
        //i = si mat lena buz si ko compare karna hai si+1 ke elements se
        for (int i = si + 1; i < ei; i++) {
            if (input[i] <= pivot) {
                count++;
            }
        }
        //shifting pivot to pivot index
        int pivotIndex = count + si;
        input[si] = input[pivotIndex];
        input[pivotIndex] = pivot;

        int i = si, j = ei;
        while (i < pivotIndex && j > pivotIndex) {
            if (input[i] <= pivot) {
                i++;
            } else if (input[j] > pivot) {
                j--;
            } else {
                int temp = input[i];
                input[i] = input[j];
                input[j] = temp;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    public static void quickSort(int[] input, int si, int ei) {
        //base case
        if (si >= ei) {
            return;
        }
        //partitionIndex is nothing but "pivotIndex" buz partition function is returning pivotIndex which we are storing in partition index
        int partitionIndex = partition(input, si, ei);
        quickSort(input, si, partitionIndex - 1);
        quickSort(input, partitionIndex + 1, ei);
    }


    public static void main(String[] args) {
        //  String s ="snnehxaxxx";
        // System.out.println(removeX(s));
        //System.out.println(replaceCharacterRecursively(s,'x','v' ));
//        System.out.println((removeDuplicates(s)));
        //random facts
//        int x = Integer.MAX_VALUE;
//        System.out.println(x);
//        System.out.println(x+1);
//        System.out.println(x+2);
        int input[] = {1, 9, 0, 17, -3, -7};
        mergeSort(input, 0, input.length - 1);
        print(input);
        System.out.println();
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        // print(input);


    }
}
