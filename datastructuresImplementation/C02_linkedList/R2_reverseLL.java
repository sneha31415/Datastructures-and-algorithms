package C2_linkedList;
import static C2_linkedList.C8_insertNodeInLL.print;
import static C2_linkedList.C8_insertNodeInLL.takeInput2;
class doubleNode{
    Node<Integer> head;
    Node<Integer> tail;
    //constructor
    doubleNode(Node<Integer> head, Node<Integer>tail){
        this.head = head;
        this.tail = tail;
    }
    doubleNode(){
    }

}
public class R2_reverseLL {
    // O(N^2) solution
    public static Node<Integer> reverseLLR(Node<Integer> head){
        //base case
        if(head==null||head.next==null){
            return head;
        }
        Node<Integer>smallHead = reverseLLR(head.next);
       Node<Integer> tail = smallHead;
       while(tail.next!=null){
           tail = tail.next;
       }
       tail.next =head;
       head.next = null;
       return smallHead;
    }

    //O(N) solution
    public static doubleNode reverseLLRBetter(Node<Integer> head){
       doubleNode ans;
        if(head==null || head.next ==null){
            ans = new doubleNode(head,head);
//          ans.head = head;
//          ans.tail = head;
          return ans;
        }
        doubleNode smallAns = reverseLLRBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        ans = new doubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
    }
    public static Node<Integer> reverseLLRBetter1(Node head){
        doubleNode ans = reverseLLRBetter(head);
        return ans.head;
    }
    public static Node<Integer> reverseLLRBest(Node head){
        if(head==null||head.next ==null){
            return head;
        }
        Node<Integer> smallHead = reverseLLRBest(head.next);
        head.next.next= head;
        head.next = null;
        return smallHead;
    }



    public static void main(String[] args) {
        Node<Integer> head = takeInput2();
        //Node<Integer> reverse = reverseLLR(head);
        Node<Integer> reverse2 = reverseLLRBest(head);
       // print(reverse);
        print(reverse2);

    }
}
