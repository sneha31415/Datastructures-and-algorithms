package C2_linkedList;
import static C2_linkedList.C8_insertNodeInLL.print;
import static C2_linkedList.C8_insertNodeInLL.takeInput2;
import static C2_linkedList.R3_midpoint.mid;
import static C2_linkedList.R4_mergeTwoSortedLL.merge;
public class R5_mergesort {
    public static Node<Integer> mergesort(Node <Integer> head){
        if(head==null || head.next==null){
            return head;
        }
        Node<Integer> mid = mid(head);
        Node<Integer> head1= head;
        Node<Integer> head2 = mid.next;
        mid.next = null; //breaking connection;

       Node<Integer> sort1 = mergesort(head1);
       Node<Integer> sort2 = mergesort(head2);
       Node<Integer>finalHead = merge(sort1,sort2);
       return finalHead;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput2();
        print(head);
        Node<Integer> ans = mergesort(head);
        print(ans);

    }
}
