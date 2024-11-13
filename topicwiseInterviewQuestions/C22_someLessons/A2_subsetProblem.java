package C22_someLessons;
import java.util.*;
//genearte all subsets
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

public class A2_subsetProblem {

//    VVVIMP: intuition : we have two options : take the elem or not take the curr elem
//    thus we form a tree, Now do bfs on this tree. The leaf nodes give us the answer
    public static List<List<Integer>> subsetsBFS(int[] nums) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (int idx = 0; idx < nums.length; idx++){
            int level = queue.size();

            for (int i = 0; i < level; i++) {
                List<Integer> rawSubset = queue.poll();
                // we choose to add the curr elem
                List<Integer> notAdd = new ArrayList<>(rawSubset);
                queue.add(notAdd);
                // we choose to add the curr elem
                List<Integer> include = new ArrayList<>(rawSubset);
                include.add(nums[idx]);
                queue.add(include);
            }
        }

        // finally add all the subsets from queue to list
        List<List<Integer>> subsets = new ArrayList<>();
        while (!queue.isEmpty()) {
            subsets.add(queue.poll());
        }
        return subsets;
    }

    // approach 2
    // intuition : 1 is represented as 1, 2 -> 10, 3 -> 100, 4 -> 1000, 5 -> 10000
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> powerSet = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++){
            powerSet.add(filter(i, nums));
        }
        return powerSet;
    }

    private static List<Integer> filter(int n, int[] nums){
        ArrayList<Integer> subset = new ArrayList<>();
        int i = 0;
        while(n > 0){
            if((n & 1) == 1){
                subset.add(nums[i]);
            }
            // divide n by 2
            n >>= 1;
            i++;
        }
        return subset;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
        System.out.println(subsetsBFS(nums));

            ArrayList<Integer> l = new ArrayList<>();
            Collections.addAll(l,1, 2,1);
            Integer[]arr = l.toArray(new Integer[0]);
    }
}
