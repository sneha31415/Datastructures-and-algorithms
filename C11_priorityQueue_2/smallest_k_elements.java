package C11_priorityQueue_2;

import java.util.PriorityQueue;

public class smallest_k_elements {
    public static int[] smallest_k(int arr[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i = 0; i<k; i++){
            pq.add(arr[i]);
        }
        for(int i = k; i< arr.length; i++){
            if(pq.peek() > arr[i]){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        int ans [] = new int [k];
        for(int i =0; i< k; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {4,1,5,7,8,3,10,11,70,32,14};
        int ans[] = smallest_k(arr, 4);
        for(int i = 0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}
