package GFG.Backtracking.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctCombinationSum {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), candidates, target);
        return res;
    }

    private void dfs(int index, List<Integer> cur, int[] candidates, int target) {
        // EXIT CONDITION
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }


        cur.add(candidates[index]);
        dfs(index + 1, cur, candidates, target - candidates[index]);
        cur.remove(cur.size() - 1);

        while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
            index++;
        }
        dfs(index + 1, cur, candidates, target);
    }
}
