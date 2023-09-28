package GFG.Tree;

public class SizeOfTree {
    public int findSizeOfTree(Node node) {
        if(node == null) {
            return 0;
        }

        return findSizeOfTree(node.left) + findSizeOfTree(node.right) + 1;
    }
    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.right.right = new Node(70);

        SizeOfTree sizeOfTree = new SizeOfTree();
        int size = sizeOfTree.findSizeOfTree(node);
        System.out.println(size);
    }
}
