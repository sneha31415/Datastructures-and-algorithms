package C4_queue;

public class QueueUsingArrayUse{
    public static void main(String[] args) throws QueueEmptyException{
        queueUsingArray q = new queueUsingArray();
//        q.enqueue(10);
//        System.out.println(q.dequeue());
//        System.out.println(q.isEmpty());
        int data[] = {1,2,3,8,9,10,11,12};
        for(int elem:data){
        q.enqueue(elem);
        }
        while(!q.isEmpty()){
            System.out.print(q.dequeue()+" ");
        }

    }
}

