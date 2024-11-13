package C2_linkedList;
import java.util.ArrayList;
public class C1_ArrayListDemo {
    public static void main(String[] args) {
       // ArrayList<Integer> arr= new ArrayList<>();
        //so now initial capacity of arrayList is 20 and not 10
        ArrayList<Integer> arr= new ArrayList<>(2);
        arr.add(10);
        arr.add(20);
        arr.add(30); //10 20 30
        arr.add(1,50); //10 50 20 30
        System.out.println(arr.size());
        System.out.println(arr.get(1));
        arr.set(2,3); // 10 50 3 30
        System.out.println(arr.get(2));
        arr.remove(1); //10 3 30
        Integer i =3; //element 3 will be removed and not index 3 ka element
        arr.remove(i);  //10 30
        System.out.println(arr.get(1));

        //printing using normal for loop
        for(int j=0;j< arr.size();j++){
            System.out.print(arr.get(j)+" ");
        }

        //enhanced for loop
        for(int j : arr){
            System.out.print(j+" ");
        }
    }
}
