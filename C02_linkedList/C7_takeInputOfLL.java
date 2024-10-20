package C2_linkedList;

import java.util.Scanner;

public class C7_takeInputOfLL {
    public static Node<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        Node<Integer> head = null;
        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if (head == null) {
                head = currentNode;
            } else {
                Node<Integer> tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = currentNode;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void print(Node<Integer> head) {
        Node<Integer> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; //i.e temp =n1.next, i.e "temp = n2"
        }
        System.out.println(); //endl
    }

    // o(n) time complexity
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


    public static void main(String[] args) {
        Node<Integer>head =takeInput();
        Node<Integer>head2 =takeInput2();
        print(head);
        print(head2);

    }
}
