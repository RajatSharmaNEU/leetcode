package GFG.Tree;

public class TreeToDLL {
    Node prev = null;

    public Node convertToDLL(Node root) {
        if (root == null) {
            return null;
        }

        Node head = convertToDLL(root.left);
        if(prev == null) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }

        prev = root;
        convertToDLL(root.right);
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.right = new Node(20);
        node.right.left = new Node(30);
        node.right.right = new Node(35);

        TreeToDLL treeToDLL = new TreeToDLL();
        Node head = treeToDLL.convertToDLL(node);

        while (head != null) {
            System.out.println(head.key);
            head = head.right;
        }
    }
}
