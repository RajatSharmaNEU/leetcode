package GFG.Tree;

public class DiameterOfBinaryTree {
    int maxHeight = 0;

    public int findHeight(Node node) {
        if (node == null) {
            return 0 ;
        }

        int lh = findHeight(node.left);
        int rh = findHeight(node.right);

        maxHeight = Math.max(lh + rh + 1, maxHeight);
        return Math.max(lh,  rh) + 1;
    }

//    public int height(Node node) {
//        if (node == null) {
//            return 0 ;
//        }
//
//        int lh = height(node.left);
//        int rh = height(node.right);
//
//        return Math.max(lh,  rh) + 1;
//    }
//
//    public int findMaxDiameter(Node node) {
//        if (node == null) return 0;
//        int d1 = 1 + height(node.left) + height(node.right);
//        int d2 = findMaxDiameter(node.left);
//        int d3 = findMaxDiameter(node.right);
//
//        return Math.max(d1, Math.max(d2, d3));
//    }

    public static void main(String[] args) {
//        Node node = new Node(10);
//        node.left = new Node(20);
//        node.right = new Node(60);
//
//        node.left.left = new Node(30);
//        node.left.left.left = new Node(40);
//        node.left.left.right = new Node(50);
//
//        node.left.right = new Node(80);
//        node.left.right.right = new Node(90);
//        node.left.right.right.right = new Node(18);

        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);

        node.right.left = new Node(40);
        node.right.right = new Node(60);
        node.right.left.left = new Node(50);
        node.right.right.right = new Node(70);

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        diameterOfBinaryTree.findHeight(node);
        System.out.println(diameterOfBinaryTree.maxHeight);
    }
}
