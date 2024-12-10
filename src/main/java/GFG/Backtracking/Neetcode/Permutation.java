package GFG.Backtracking.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> findPermutation(int[] nums) {
        if(nums.length == 0){
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> perms = findPermutation(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> perm: perms) {
            for (int i = 0; i <= perm.size(); i++) {
                List<Integer> permCopy = new ArrayList<>(perm);
                permCopy.add(i, nums[0]);
                result.add(permCopy);
            }
        }
        return result;
    }

    static List<List<Integer>> res;

    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        DFS(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    public static void DFS(List<Integer> perm, int[] nums, boolean[] pick) {
        if(perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!pick[i]) {
                // Left
                perm.add(nums[i]);
                pick[i] = true;

                // continue
                DFS(perm, nums, pick);

                // Right
                perm.remove(perm.size() - 1);
                pick[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
//        List<List<Integer>> result = findPermutation(arr);
        List<List<Integer>> result = permute(arr);
        System.out.println(result);
    }
}
