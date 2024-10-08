package GFG.SegmentTree;

import java.util.Arrays;

public class UpdateSum {
    public static void updateSegmentTree(int ss, int se, int i, int si, int diff, int[] tree) {
        if (i < ss || i > se) return;

        tree[si] = tree[si] + diff;

        if (se > ss) {
            int mid = (ss + se) / 2;
            updateSegmentTree(ss, mid, i, (2 * si) + 1, diff, tree);
            updateSegmentTree(mid + 1, se, i, (2 * si) + 2, diff, tree);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30, 40};
        int[] tree = ConstructSegmentTree.createSegmentTree(arr);

        System.out.println("Before Update" + Arrays.toString(tree));
        updateSegmentTree(0, arr.length - 1, 1, 0, 5, tree);
        System.out.println("After Update" + Arrays.toString(tree));
    }
}
