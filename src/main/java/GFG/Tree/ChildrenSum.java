package GFG.Tree;

public class ChildrenSum {
    public boolean isChildrenSumTree(Node node) {
        if(node ==  null) {
            return true;
        }

        if(node.left == null && node.right == null) {
            return true;
        }

        int left = node.left == null ? 0 : node.left.key;
        int right = node.right == null ? 0 : node.right.key;

        if(node.key != left + right) {
            return false;
        }

        return isChildrenSumTree(node.left) && isChildrenSumTree(node.right);
    }
    public static void main(String[] args) {
//        Node node = new Node(20);
//        node.left = new Node(8);
//        node.right = new Node(12);
//        node.left.left = new Node(3);
//        node.left.right = new Node(5);

//        Node node = new Node(3);
//        node.left = new Node(1);
//        node.right = new Node(2);
//        node.right.left = new Node(1);
//        node.right.right = new Node(2);

        Node node = new Node(10);
        node.left = new Node(8);
        node.right = new Node(2);
        node.right.left = new Node(2);

        ChildrenSum childrenSum = new ChildrenSum();
        System.out.println(childrenSum.isChildrenSumTree(node));
    }
}
