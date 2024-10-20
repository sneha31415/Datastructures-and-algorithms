package C8_Hashmaps;

public class mapNode<K, V> {
    K key;
    V value;
    //since this is a link list node, so we will also store next node address
    mapNode<K, V> next;
    public mapNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
