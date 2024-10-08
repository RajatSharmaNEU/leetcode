package GFG.SegmentTree;

import java.util.Arrays;

public class ConstructSegmentTree {

    public static int[] createSegmentTree(int[] arr) {
        int n = arr.length;
        int[] tree = new int[4 * n];
        int root = CST(0, n - 1, 0, arr, tree);

        System.out.println(Arrays.toString(tree));
        return tree;
    }

    public static int CST(int ss, int se, int si, int[] arr, int[] tree) {
        // exit condition
        if(ss == se) {
            tree[si] = arr[ss];

        } else {
            int mid = (ss + se)/2;
            tree[si] = CST(ss, mid, 2*si + 1, arr, tree) // left tree
                       + CST(mid + 1, se, 2*si + 2, arr, tree); // right tree

        }

        return tree[si];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40};
        createSegmentTree(arr);
    }
}
