package C8_Hashmaps;

import java.util.ArrayList;

public class map<K, V> {
    ArrayList<mapNode<K, V>> buckets;
    int size; //size is zero bydefault
    int numBuckets;

    public map() {
        numBuckets = 5;
        buckets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            buckets.add(null);  //initially all the nodes are null
        }
    }

    //finding the bucketindex for any key
    private int getBucketIndex(K key) {
        /*step1 = get the hashcode
          step2 = get the compressed integer */

        //EVERY OBJECT IN JAVA IS INHERITED FROM THE OBJECT CLASS SO, EVEN GENERICS IS INHERITED FROM THAT
        int hashcode = key.hashCode(); //.hashcode() = inbuilt func implemented in object class
        return hashcode % numBuckets;
    }

    public int size(){
        return size;
    }

    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        mapNode<K, V> head = buckets.get(bucketIndex);

        //first we will traverse over the whole linkedlist to check if the key already exists
        while (head != null) {
            //case1
            if (head.key.equals(key)) {     // NOTE : (head.key == key) is wrong
                //so, we have got a box that contains the key already so just update the corresponding value
                head.value = value;
            }
            head = head.next;
        }
        //we have moved to head = null buz of the above code, so we need to update it
        head = buckets.get(bucketIndex);
        mapNode<K, V> newElementNode = new mapNode<>(key, value);
        size++; //creation of new node so size++
        newElementNode.next = head;
        buckets.set(bucketIndex, newElementNode);
        double loadFactor = (1.0*size)/numBuckets; //size/numBuckets = int/int = int, so we need to covert size to float so that overall ans is float otherwise 17/20 will give 0,, whereas 17.0/20 = 0.85
        if(loadFactor>0.7){
            rehash(); //rehash() will be a private function
        }
    }

    private void rehash(){
        System.out.println("rehashing: + buckets: " + numBuckets + "size: " + size);
        //copy buckets arraylist into temp
        ArrayList<mapNode<K, V>> temp = buckets;
        //Now doubling the size of the buckets arraylist and inilialising it with null
        buckets = new ArrayList<>();
        for(int i=0;i<2*numBuckets; i++){
            buckets.add(null);
        }
        //update size and numBuckets
        size = 0;
        numBuckets = 2*numBuckets;

        //now goto each bucket and LL of every bucket and the insert it in the new enlarged arraylist
        for(int i=0; i< temp.size(); i++){
            mapNode<K, V> head = temp.get(i);
            //traverse the linklist of each head(bucket)
            while(head != null){
                 K key = head.key;
                 V value = head.value;
                 insert(key, value); //VVIMP NOTE IS THAT THE insert() FUNC WORKS AS PER "numbuckets"  SO BUCZ NUMBUCKETS IS NOW UPDATED TO TWICE THE VALUE, SO THE INSERTION WILL TAKE PLACE IN THE NEW BUCKETS(of twice size) ONLY AND NOT TEMP(of the original size)
                 head = head.next;
            }
        }
    }

    //you will be given the key, return value corresponding to it
    public V get_value(K key) {
        int bucketIndex = getBucketIndex(key);
        mapNode<K, V> head = buckets.get(bucketIndex);
        //traverse the LL to find the key and if key not found then return null
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        // if we reach this line then, whole LL is traversed and the key is not found
        return null;
    }
    //REMOVE THE KEY AND RETURN THE CORRESPONDING VALUE
    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        mapNode<K, V> head = buckets.get(bucketIndex);
        mapNode<K, V> prev = null;
        while(head!=null){
            if(head.key.equals(key)){
                size--;
                if(prev==null){
                   buckets.set(bucketIndex,head.next); //THIS SETS THE HEAD TO THE NEXT NODE CUZ THE ARRAYLIST BUCKETS CONTAIN ALL THE HEADS
                }
                else{
                    prev.next = head.next; //head ke side wle jo do elems hai unmei connection banaya
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    //temporary func for visualising rehashing
    public double loadFactor(){
        return (1.0*size)/numBuckets;
    }

}
