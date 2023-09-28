package GFG.Tree;

public class MaxOfTree {
    public int findMax(Node node) {
        if(node == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(node.key, Math.max(findMax(node.left), findMax(node.right)));
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.right.right = new Node(70);

        MaxOfTree maxOfTree = new MaxOfTree();
        System.out.println(maxOfTree.findMax(node));
    }
}
