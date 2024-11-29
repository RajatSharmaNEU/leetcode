package GFG.Hashing.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductExceptSelf {

    public static int[] usingCountZero(int[] nums) {
        int product = 1;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i);
                continue;
            }

            product = product * nums[i];
        }

        int[] res = new int[nums.length];

        if (list.size() > 1) {
            return res;
        }

        if (list.size() == 1) {
            res[list.get(0)] = product;
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = product / nums[i];
        }

        return res;
    }

    public static int[] usingPrefixSuffix(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {-1,1,0,-3,3};
        int[] arr2 = new int[] {1,2,3,4};

        System.out.println(Arrays.toString(usingCountZero(arr1)));
        System.out.println(Arrays.toString(usingPrefixSuffix(arr1)));

        System.out.println(Arrays.toString(usingCountZero(arr2)));
        System.out.println(Arrays.toString(usingPrefixSuffix(arr2)));
    }
}
