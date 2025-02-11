package GFG.Backtracking.Neetcode;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public void DFS(int[] nums, int index, List<Integer> curr, List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        DFS(nums, index + 1, curr, result);

        curr.add(nums[index]);
        DFS(nums, index + 1, curr, result);
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        List<List<Integer>> result = subSets.subsets(new int[]{1,2,3});

        for(List<Integer> list: result) {
            System.out.println(list.toString());
        }
    }
}
