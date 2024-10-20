package C4_queue;

import java.util.LinkedList;
import java.util.Queue;

public class collections_framework {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        System.out.println(q.size());
        System.out.println(q.isEmpty());
        //we can also implement queue methods using q
        q.poll(); //same as q.remove()
        System.out.println(q.size());

    }
}
