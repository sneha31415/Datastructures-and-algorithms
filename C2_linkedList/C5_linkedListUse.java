package C2_linkedList;

public class C5_linkedListUse {
    //function
    public static Node <Integer> createLinkedList(){
         Node <Integer> n1 = new Node<>(10);
         Node <Integer> n2 = new Node<>(20);
         Node <Integer> n3 = new Node<>(30);
         Node <Integer> n4 = new Node<>(30);
         //n1,n2,n3.. ARE REFERENCES
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //printing
        System.out.println("n1: "+n1+"n1 data: "+n1.data+" reference of next node: "+n1.next);
        System.out.println("n2: "+n2+"n1 data: "+n2.data+" reference of next node: "+n2.next);
        System.out.println("n3: "+n3+"n3 data: "+n3.data+" reference of next node: "+n3.next);
        System.out.println("n4: "+n4+"n3 data: "+n4.data+" reference of next node: "+n4.next);
        //no need to do n4.next = null buz bydefault value is null
        return n1; //head(first node) ka reference return karna hai
    }
    public static void print(Node<Integer> head){
        System.out.println("print: "+head);
        System.out.println("print: "+head.data);
        System.out.println(head.next.data); //n2 data
        System.out.println(head.next.next);//n3 adress
        System.out.println(head.next.next.data); // n3 data
    }


    public static void main(String[] args) {
        //Node<String> n2 =new Node<>("sneha");
        Node<Integer> n0 =new Node<>(20);
        System.out.println(n0);
        //we can access n1 and n2 only within the scope they are declared in, so, they are accessible only in createLinkedList class
        //System.out.println(n1);
       // System.out.println(n2);
        System.out.println(n0.data);
        System.out.println(n0.next);
        //with the below func calling, all info about n1,n2,n3,n4 can be known
        Node <Integer> head= createLinkedList();
        System.out.println("main: "+head);
        System.out.println("main: "+head.data);
        print(head);

    }
}
