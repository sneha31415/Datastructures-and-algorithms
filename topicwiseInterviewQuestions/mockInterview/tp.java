package mockInterview;
import java.util.*;

public class tp {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void helper(int[] candidates, int currIdx, int target, List<Integer> combination, List<List<Integer>> combos) {
        if (currIdx == candidates.length && target == 0) {
            combos.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0 || currIdx >= candidates.length) return;

        // include the curr elem
        combination.add(candidates[currIdx]);
        helper(candidates, currIdx + 1, target - candidates[currIdx], combination, combos);
        combination.remove(combination.size() - 1);

        // we can skip an elem only if its not same as last elem
        if (combination.size() == 0 || combination.get(combination.size() - 1) != candidates[currIdx]) {
            helper(candidates, currIdx + 1, target, combination, combos);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {1, 1, 1} ;
        int target = 2;
        System.out.println(combinationSum2(candidates, target));
    }
}
