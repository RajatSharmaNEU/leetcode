package GFG.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Practice {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> getCombination(int[] candidates, int target) {
        helper(0, new ArrayList<>(), candidates, target);
        return res;
    }

    public static void helper(int index, List<Integer> currList, int[] candidates, int target) {
        if(target == 0) {
            res.add(currList);
            return;
        }

        if(target < 0 || index == candidates.length) {
            return;
        }

        currList.add(candidates[index]);
        helper(index, currList, candidates, target - candidates[index]);

        currList.remove(currList.size() - 1);
        helper(index + 1, currList, candidates, target);
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
    }
}
