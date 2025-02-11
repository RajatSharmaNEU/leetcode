package Oracle;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        fillRightView(result, root, 0);
        return result;
    }

    public void fillRightView(List<Integer> result, TreeNode root, int currLevel) {
        if (root == null) {
            return;
        }

        if (result.size() == currLevel) {
            result.add(root.val);
        }

        fillRightView(result, root.right, currLevel + 1);
        fillRightView(result, root.left, currLevel + 1);
    }
}
