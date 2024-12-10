package GFG.Backtracking.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubSetWithoutDuplicate {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        DFS(0, new ArrayList<>(), nums);
        return res;
    }

    public void DFS(int index, List<Integer> currList, int[] nums) {

        if (index == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }

        // RIGHT
        currList.add(nums[index]);
        DFS(index + 1, currList, nums);
        currList.remove(currList.size() - 1);

        // LEFT
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        DFS(index + 1, currList, nums);
    }
}
