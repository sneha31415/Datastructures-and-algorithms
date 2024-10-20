package C2_linkedList;
import java.util.LinkedList;
public class R6_javaFrameworks {
    public static void main(String[] args)  {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30); // 10 20 30
        list.add(1,15); // 10 15 20 30
        //no need to build connections here, it is automatically done by the add() func
        list.addFirst(5); //5 10 15 20 30
        int ans = list.get(1);
        System.out.println(ans);
        System.out.println(list.size());
        list.add(1,20);
        list.set(0,90); //90 20 10 15 20 30

        //printing all the nodes
        for(int i =0;i< list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }
}
