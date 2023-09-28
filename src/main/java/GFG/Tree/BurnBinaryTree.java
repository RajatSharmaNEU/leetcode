package GFG.Tree;

public class BurnBinaryTree {

    public void burnBinaryTree() {

    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);

        node.left.left = new Node(40);
        node.left.right = new Node(50);

        node.right.right = new Node(60);

        BurnBinaryTree burnBinaryTree = new BurnBinaryTree();
        burnBinaryTree.burnBinaryTree();
    }
}
