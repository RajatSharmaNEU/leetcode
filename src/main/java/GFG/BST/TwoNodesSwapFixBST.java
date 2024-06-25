package GFG.BST;

public class TwoNodesSwapFixBST {
    static Node prev, first, second;

    public static void findTwoNodes(Node root) {
        if(root == null) return;

        findTwoNodes(root.left);

        if(prev!=null && root.key < prev.key) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        findTwoNodes(root.right);
    }

    public static void main(String[] args) {
       Node root = new Node(20);

       root.left = new Node(60);
       root.left.left = new Node(4);
       root.left.right = new Node(10);

       root.right = new Node(80);
       root.right.left = new Node(8);
       root.right.right = new Node(100);

//        Node root = new Node(60);
//
//        root.left = new Node(8);
//        root.left.left = new Node(4);
//        root.left.right = new Node(10);
//
//        root.right = new Node(80);
//        root.right.left = new Node(20);
//        root.right.right = new Node(100);

       findTwoNodes(root);
       System.out.println("first Node - " + first.key + " , second Node - " + second.key);
    }
}
