package C2_linkedList;

import java.util.Scanner;

public class C8_insertNodeInLL {
    public static Node<Integer> insert(Node<Integer> head, int elem, int pos){
        Node<Integer> newNode = new Node<>(elem);
        if(pos==0){
        newNode.next = head;
       /* head = newNode; //updating head of the LL to newNode
        return head;   */
        return newNode; // instead of the previous two lines we can just write this
        }
        else {
            int count = 0;
            Node<Integer> prev = head;
            while (prev != null && count < pos - 1) {
                prev = prev.next;
                count++;
            }
            if (prev != null) {
                newNode.next = prev.next;
                prev.next = newNode;
            }
        }
        return head;
    }

    //DELETE NODE
    public static Node<Integer> deleteNode(Node<Integer> head,int pos) {

        if(pos==0){
           /* head = head.next;
            return head; */
            return head.next; //previous 2 lines can be written as
        }

        else{
            Node<Integer> prev = head;
            int count = 0;
            while(prev!=null && count<pos-1){
                prev = prev.next;
                count++;
            }
            if(prev!=null && prev.next!=null){
                prev.next =prev.next.next; //last dot ke pehle jo bhi hai must not be null i.e prev and prev.next must not be null
             }
        }
        return head;
    }


    public static void print(Node<Integer> head){
        Node<Integer>temp = head;
        while(temp!=null){
            System.out.print (temp.data +" ");
            temp = temp.next; //i.e temp =n1.next, i.e "temp = n2"
        }
        System.out.println(); //endl
    }

    public static Node<Integer> takeInput2() {
        Scanner sc= new Scanner(System.in);
        int data = sc.nextInt();
        Node <Integer> head=null,tail =null;
        while(data!=-1){
            Node<Integer> currentNode = new Node <Integer> (data);
            if(head == null){
                head = currentNode;
                tail = currentNode;
            }
            else{
                tail.next= currentNode;
                tail = tail.next; //or tail = currentNode;
            }
            data = sc.nextInt();
        }

        return head;
    }

    public static  void main(String[] args) {
        Node<Integer> head = takeInput2();
        System.out.println(head);

       // Node<Integer> n1= insert(head,20,5); //this will give nullPointerException,,but we added this case in while loop so while loop will not be entered in this case

         Node<Integer> n1= insert(head,20,0); //this will return newNode i.e the updated head,,we are cellceting  the updated head in n1
        //"head" variable still has the previous head only ,, and n1 has the updated head
       //to update the variable head,do,, -->
        /*  head  = insert(head,20,0);
            print(head);    */
        System.out.println(head);

        print(n1); //n1 is the updated head
        print(head); //this head is of main and not of insert func,, everything in java in pass by value
        //head of main is not updated, so we need to make the return type of the func as a Node so that we can pass the updated Node to main
        n1= deleteNode(n1,0);
        print(n1);


    }

}
