package C2_linkedList;

import static C2_linkedList.C8_insertNodeInLL.takeInput2;


public class R1_printLL {
    public static void printR(Node<Integer> head){
        //base case
    if(head==null){
        return;
    }
       System.out.print(head.data+" ");
        printR(head.next);
      // System.out.print(head.data+" "); //prints in reverse order
    }

    public static Node<Integer> insertR(Node<Integer>head,int ele, int pos){
        if(head==null&&pos>0){
            return head;
        }
        //base case
        if(pos==0){
            Node<Integer>newhead = new Node<>(ele);
            newhead.next= head;
            return newhead;
        }

        Node<Integer> newHead1= insertR(head.next,ele,pos-1);
        head.next = newHead1;
        return head;
    }

    public static Node<Integer> deleteNodeR(Node<Integer> head, int pos){
        if(head==null){
            return head;
        }
        //base case
        if(pos==0){
            return head.next;
        }
        Node<Integer>smallHead=deleteNodeR(head.next,pos-1);
        head.next =smallHead; //making connections
        return head;
    }

    public static void main(String[] args) {
       Node <Integer> head = takeInput2();
        printR(head);
        System.out.println();
        head= insertR(head,12,9);
        deleteNodeR(head,10);
        printR(head);
    }
}
