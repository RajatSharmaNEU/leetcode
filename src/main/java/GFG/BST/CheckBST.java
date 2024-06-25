package GFG.BST;

public class CheckBST {
    public static boolean isBST(Node root, int min, int max) {
        if(root == null) {
            return true;
        }

        if(root.key < min || root.key > max) {
            return false;
        }

        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }

    // Inorder Traversal of BST is in Increasing Order.
    static int prev = Integer.MIN_VALUE;
    public static boolean isBST(Node root) {
        if(root == null) return true;
        if(isBST(root.left) == false) return false;
        if(root.key <= prev) return false;
        prev = root.key;
        return isBST(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(30);
        root.right.left = new Node(18);
//        root.right.left = new Node(25);
        root.right.right = new Node(35);

        System.out.println(isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isBST(root));
    }
}
