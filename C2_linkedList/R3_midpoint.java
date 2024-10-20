package C2_linkedList;
import static C2_linkedList.C8_insertNodeInLL.print;
import static C2_linkedList.C8_insertNodeInLL.takeInput2;

public class R3_midpoint {
    public static Node<Integer> mid(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
    Node<Integer> head = takeInput2();
    print(head);
    Node<Integer> ans = mid(head);
        System.out.println(ans.data);

    }
}
