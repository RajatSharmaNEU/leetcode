package GFG.Tree;

public class CheckForBalancedTree {
    public int isBalancedTree(Node node) {
        if (node == null) {
            return 0;
        }

        int lh = isBalancedTree(node.left);
        if(lh == -1) return -1;

        int rh = isBalancedTree(node.right);
        if(rh == -1) return -1;

        if (Math.abs((lh-rh)) > 1)  return -1;

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
//        Node node = new Node(30);
//        node.left = new Node(40);
//        node.right = new Node(80);
//
//        node.left.left = new Node(50);
//        node.left.right = new Node(70);
//        node.right.left = new Node(5);
//
//        node.left.right.left = new Node(20);
//        node.left.right.right = new Node(10);

        Node node = new Node(3);
        node.left = new Node(4);
        node.right = new Node(8);
        node.left.left = new Node(5);
        node.left.right = new Node(9);
        node.right.right = new Node(7);
        node.right.right.left = new Node(6);

        CheckForBalancedTree checkForBalancedTree = new CheckForBalancedTree();
        int height = checkForBalancedTree.isBalancedTree(node);
        System.out.println(height  == -1 ? false: true);
    }
}
