package GFG.Tree;

public class HeightOfBinaryTree {
    public int findHeight(Node root) {
        if(root == null) {
            return 0;
        }

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.right.left = new Node(40);
        node.right.right = new Node(50);

        HeightOfBinaryTree h = new HeightOfBinaryTree();
        System.out.println(h.findHeight(node));
    }
}
