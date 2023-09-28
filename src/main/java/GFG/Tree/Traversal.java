package GFG.Tree;
public class Traversal {
    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.println(root.key);
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if(root != null) {
            System.out.println(root.key);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.key);
        }
    }

    public static void main(String[] args) {
        Traversal t = new Traversal();
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.left.right = new Node(50);
        node.right.left = new Node(60);
        node.right.right = new Node(70);

        System.out.println("Inorder");
        t.inOrder(node);
        System.out.println("Preorder");
        t.preOrder(node);
        System.out.println("Postorder");
        t.postOrder(node);
    }

}
