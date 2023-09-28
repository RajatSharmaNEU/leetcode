package GFG.Tree;

// Recursive approach
public class PrintLeftNode {
    int maxLevel = 0;

    public void printLeftNode(Node node, int level) {
        if (node == null) {
            return;
        }

        if (maxLevel < level) {
            System.out.println(node.key);
            maxLevel = level;
        }

        printLeftNode(node.left, level + 1);
        printLeftNode(node.right, level + 1);
    }

    public static void main(String[] args) {
//        Node node = new Node(10);
//        node.left = new Node(20);
//        node.right = new Node(30);
//        node.left.left = new Node(40);
//        node.left.right = new Node(50);
//        node.right.right = new Node(60);

//        Node node = new Node(30);
//        node.right = new Node(50);
//        node.right.left = new Node(60);
//        node.right.left.right = new Node(10);

        Node node = new Node(10);
        node.left = new Node(50);
        node.right = new Node(60);
        node.right.left = new Node(70);
        node.right.right = new Node(20);
        node.right.left.right = new Node(80);

        PrintLeftNode printLeftNode = new PrintLeftNode();
        printLeftNode.printLeftNode(node, 1);
    }
}
