package C8_Hashmaps;

import java.util.HashMap;
import java.util.Set;

public class Inbuilt_func {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("abc", 3);
        map.put("def", 4);
        map.put("ABC2", 4);
        map.put("defF", 4);

        //operations of values are expensive
        if(map.containsValue(3)){
            System.out.println("this map has 3 as value");
        }

        //get value
        int v =0;
        if(map.containsKey("abc")){
            v = map.get("abc"); //gets the value of abc
        }
        System.out.println(v);

        // "remove" deletes a key from the map, we can also return the value corresponding to the key by storting it in a datatype
        int r = map.remove("abc");
        System.out.println(r);

        //iterate over the map
        //map.keySet() gives the set of all the keys in the map
        Set<String> keys = map.keySet();
        for(String str : keys){  // isse ek ek karke saari keys milte jayengi
            System.out.println(str);
            //ORDER MEI KEYS BAHAR NAHI AEYNGI
        }
    }
}
