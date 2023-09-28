package GFG.Tree;

public class KthNode {
    public void printKthNode(Node node, int k) {
        if(node == null) {
            return;
        }
        if(k == 0) {
            System.out.println(node.key);
            return;
        }

        printKthNode(node.left, k-1);
        printKthNode(node.right, k-1);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.right.right = new Node(70);

        KthNode kthNode = new KthNode();
        kthNode.printKthNode(node, 2);
    }
}
