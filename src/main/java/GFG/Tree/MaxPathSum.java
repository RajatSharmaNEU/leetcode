package GFG.Tree;

public class MaxPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        maxSplitSum(root);
        return max;
    }

    public int maxSplitSum(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxSplitSum(root.left));
        int rightSum = Math.max(0, maxSplitSum(root.right));



        max = Math.max(max, root.key + leftSum + rightSum);

        return Math.max(root.key + leftSum, root.key + rightSum);

    }
}
