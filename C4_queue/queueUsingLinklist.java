package C4_queue;

import C2_linkedList.Node;

public class queueUsingLinklist<t> {
private Node<t> front; // front,rear are not actual nodes, they are just refernces to the head and tail of the linkedList
private Node<t> rear;
int size ;
//unnecessary constructor cuz all the variables are being given their default value
public queueUsingLinklist(){
    front =  null;
    rear = null;
    size =0;
}

public int size(){
    return size;
}
public boolean isEmpty(){
    return size==0;
}
public void enqueue(t elem){
    Node<t> newNode = new Node<>(elem); //make a new node for elem as front and rear are not
    size++;
    if(front==null){
        front= newNode;
        rear = newNode;
        return;
    }
    rear.next=newNode;
    rear = newNode;

    // ** No full exception in linklist
}
public t dequeue() throws QueueEmptyException{
    if(front==null){
        QueueEmptyException e = new QueueEmptyException();
        throw e;
    }
    t temp = front.data;
    front= front.next;

    if(front==null){
        rear =null;
    }
    size--;
    return temp;

}

public t front() throws QueueEmptyException{
    if(front==null){
        QueueEmptyException e = new QueueEmptyException();
        throw e;
    }
    return front.data;
}
}



