package C10_priorityQueue;

public class priorityQueueUse {
    public static void main(String[] args) throws priorityQueueEmptyException{
        maxPriorityQueue <String> pq = new maxPriorityQueue<String>();
        pq.insert("sneha", 100);
        pq.insert("abc", 11);
        pq.insert("def", 12);
        pq.insert("ghi", 13);

        while (!pq.isEmpty()){
            System.out.println(pq.getMax());
            pq.removeMax();
        }


    }
}
