package GFG.Tree;

public class SizeOfCompleteBinaryTree {
    public int findHeight(Node root) {
        int lHeight = 0;
        int rHeight = 0;

        Node curr = root;
        while (curr.left != null) {
            lHeight++;
            curr = curr.left;
        }

        curr = root;

        while (curr.right != null) {
            rHeight++;
            curr = curr.right;
        }

        if(lHeight == rHeight) {
            return 2^lHeight - 1;
        } else {
            return findHeight(root.left) + findHeight(root.right) + 1;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);

        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        SizeOfCompleteBinaryTree heightOfCompleteBinaryTree = new SizeOfCompleteBinaryTree();
        System.out.println(heightOfCompleteBinaryTree.findHeight(node));
    }
}
