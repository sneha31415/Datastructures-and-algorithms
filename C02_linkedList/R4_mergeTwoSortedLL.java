package C2_linkedList;
import static C2_linkedList.C8_insertNodeInLL.print;
import static C2_linkedList.C8_insertNodeInLL.takeInput2;

public class R4_mergeTwoSortedLL {
    public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
        if(head1==null){
            return head2;
        }
        if(head2 ==  null){
            return head1;
        }

        Node<Integer> head = null;
        Node<Integer> tail = null;

        //deciding the head of the merged LL
        if(head1.data<head2.data){
            head = head1;
            tail = head1;
            head1 = head1.next;
        }
        else{
            head = head2;
            tail = head2;
            head2= head2.next;
        }

        //rebuilding the connections
        while(head1!=null && head2!= null){
            if(head1.data<head2.data){
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            }
            else{
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }

        //building the connection when one of the LL has ended
        if(head1 ==null){
            tail.next = head2;
        }
        if(head2 == null){
            tail.next = head1;
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> h1= takeInput2();
        Node<Integer> h2= takeInput2();
        print(h1);
        print(h2);
        Node<Integer> h = merge(h1,h2);
        print(h);
    }
}
