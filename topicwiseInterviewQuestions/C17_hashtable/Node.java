package C17_hashtable;

public class Node <T>{
    String key;
    T value;
    Node next;
    public Node(){}
    public Node(String key, T value){
        this.key = key;
        this.value = value;
        next = null;
    }
}
