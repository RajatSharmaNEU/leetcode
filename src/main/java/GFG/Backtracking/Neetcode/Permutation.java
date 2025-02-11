package GFG.Backtracking.Neetcode;

import java.util.ArrayList;
import java.util.List;

// O(n!) time complexity
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(nums, new ArrayList<>(), result);
        return result;
    }

    public void DFS(int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            // avoid repeating
            if(curr.contains(nums[i])) continue;

            curr.add(nums[i]);
            DFS(nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        Permutation permutation = new Permutation();
        List<List<Integer>> result = permutation.permute(arr);
        System.out.println(result);
    }
}
