package C2_linkedList;

public class C6_printing2_linkList {
    public static void print(Node<Integer> head){
        Node<Integer>temp = head;
        while(temp!=null){
            System.out.print (temp.data +" ");
            temp = temp.next; //i.e temp =n1.next, i.e "temp = n2"
        }
        System.out.println(); //endl
    }
    public static void increment(Node <Integer> head){
        Node <Integer> temp = head;
        while(temp!=null){
            temp.data ++;
          // System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    //Q= finding the length of linklist
    public static int length(Node<Integer>head){
        Node <Integer> temp = head;
        int count =0;
        while(temp!=null){
            count++;
            temp= temp.next;
        }
        return count;
    }

    //Q= printing the ith node in linklist //counting is as 0 1 2 3 4...
    public static void print_ith(Node<Integer>head,int i){
        Node <Integer> temp= head;   //compulsory step for iteration in Node
        int count =0;
        while(/*temp!=null &&*/ count!=i){
            temp = temp.next;
            count++;
        }
        if(count ==i){
            System.out.print(temp.data);
        }

    }




    public static void main(String[] args) {
        Node <Integer> n1 = new Node<>(10);
        Node <Integer> n2 = new Node<>(20);
        Node <Integer> n3 = new Node<>(30);
        Node <Integer> n4 = new Node<>(40);
        //building connections between nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        //n4.next = null is bydefault so,

        //printing will start
        print(n1); //so now temp = n1
        increment(n2);
        print(n1);
       // print(n2); // now head starts from n2,, so printing also starts from n2
       // print(n1.next); //n1.next = n2 so head starts from n2
        int count = length(n1);
        System.out.println(count);

        print_ith(n1,10);
    }

}
