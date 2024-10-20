package basics.WE;
//import java.util.HashMap;
//import java.util.Map;
import java.util.*;

public class hash {
    public static int word_frequency(String inputString, int n){
        int ans = 0;
        String[] words = inputString.split("[ .,!]");
        HashMap<String, Integer> freq = new HashMap<>();
        //converting the words to lower case and putting it in hashmap with zero frequency of each word
        // initialiasing
//        for(var word: words){
//            freq.put(word.toLowerCase(), 0);
//        }
//
//        for(var word: words){
//            freq.put(word.toLowerCase(), freq.get(word.toLowerCase())+1);
//        }

        for(String word: words){
            String x = word.toLowerCase();  // key of hashmap
            Integer value = freq.getOrDefault(x, 0) + 1; // calc value
            freq.put(x, value); // store
        }
// datatype is Entry here
        for(Map.Entry<String, Integer> e: freq.entrySet()){
            e.getKey(); // key -> banana
            e.getValue(); // value -> 2
            if(e.getValue() == n){
                ans += 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String q = "hello world! hello i i i  am Sneha from India";
        int ans =word_frequency(q,2);
        System.out.println(ans);

    }
}
