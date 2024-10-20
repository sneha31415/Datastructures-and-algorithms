package C3_stacks;
import C2_linkedList.Node;
//import java.util.LinkedList.Node; this is wrong why??
public class stackUsingLL<t> {
    private Node<t> head;
    private int size;

    public stackUsingLL(){
        head = null;
        size =0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void push(t elem){
        // we do not need to handle the size==0 case separately bcuz it is handled in the below code itself
            Node<t> newNode = new Node(elem);
            newNode.next = head;
            head = newNode;
            size ++;
        }
    public t top() throws stackEmptyException{
        if(head == null){
            throw new stackEmptyException();
        }
        return head.data;
    }
    public t pop() throws stackEmptyException{
        if(head == null){
            throw new stackEmptyException();
        }
        t temp = head.data;
        head = head.next;
        size--;
        return temp;

    }

}
