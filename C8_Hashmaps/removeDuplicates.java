package C8_Hashmaps;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class removeDuplicates {
    public static ArrayList<Integer> removeDuplicates(int []arr){
        ArrayList<Integer>  output = new ArrayList<>();
        //THIS WILL SAVE THE ELEMENTS WHICH WE HAVE SEEN
        HashMap<Integer, Boolean> seen = new HashMap<>();
        for(int i=0; i< arr.length;i++){
            if(!seen.containsKey(arr[i])){
                output.add(arr[i]);
                seen.put(arr[i],true);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int arr[] = {1,4,5,4,6,6,6,6,3,3,1};
        ArrayList<Integer> output = removeDuplicates(arr);
        for(int i=0;i< output.size();i++){
            System.out.println(output.get(i));
        }
    }
}
