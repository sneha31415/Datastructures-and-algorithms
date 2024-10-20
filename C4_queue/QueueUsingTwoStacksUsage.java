package C4_queue;

public class QueueUsingTwoStacksUsage {
    public static void main(String[] args) throws QueueEmptyException {
        queueUsingTwoStacks q = new queueUsingTwoStacks();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.dequeue());

    }
}
