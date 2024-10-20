package C2_linkedList;
// node class to make node objects
public class Node<t> {
    // data and next are attributes of class Node and so they will be access using dot operator on the objects of class Node
    public t data;
    public Node next; //we have not created an object of "next" here(buz new keyword is not used), we have just created a refernce,,,so next is foro reference i.e connection
    public Node(t data){
        this.data = data;
    }
}

//we need not extend node class anywhere as it is a public class and we can just making its objects
