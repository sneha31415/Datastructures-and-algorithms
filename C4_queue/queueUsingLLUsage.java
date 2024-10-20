package C4_queue;

public class queueUsingLLUsage {
    public static void main(String[] args) throws QueueEmptyException{
        queueUsingLinklist<Integer> q = new queueUsingLinklist<>();
        int arr[] ={ 10,20,30,40 };
        for(int elem:arr){
            q.enqueue(elem);
        }
        while(!q.isEmpty()){
            System.out.println(q.dequeue());
        }

    }
}
