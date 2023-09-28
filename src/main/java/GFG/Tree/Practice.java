package GFG.Tree;

public class Practice {
    // ChildrenSum
    // CheckForBalancedTree
    // LCA

    public boolean isChildrenSumTree(Node node) {
        if(node == null) {
            return true;
        }

        if(node.left == null && node.right == null) {
            return true;
        }

        int left = node.left == null ? 0 : node.left.key;
        int right = node.right == null ? 0 : node.right.key;

        if(node.key != left + right) {
            return false;
        }


        return isChildrenSumTree(node.left) && isChildrenSumTree(node.right);
    }

    public int isBalancedTree(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = isBalancedTree(node.left);
//        if(lh == -1) return -1;

        int rh = isBalancedTree(node.right);
//        if(rh == -1) return -1;

        if(Math.abs(lh -rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }

    public Node LCA(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.key == n1 || root.key == n2) {
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if(leftLCA !=null && rightLCA!=null) {
            return root;
        }

        if(leftLCA!=null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(50);
        node.right = new Node(60);

        node.left.left = new Node(70);
        node.left.right = new Node(20);

        node.left.left.left = new Node(40);
        node.left.right.left = new Node(90);
        node.left.right.right = new Node(80);
        node.left.right.left.left = new Node(30);

        Practice lca = new Practice();
        System.out.println(lca.LCA(node, 30, 80).key);
    }

}
