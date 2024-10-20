package C11_priorityQueue_2;

import java.util.PriorityQueue;

public class inbuilt_PQ {
    public static void main(String[] args) {
        //by default it is a min priority Queue
        String arr[] = {"str", "abc", "zh", "Str"};
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int i =0; i< arr.length; i++){
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            System.out.print(pq.peek()  + " ");
            pq.poll(); //for removing the element with the min priority
        }

    }
}
