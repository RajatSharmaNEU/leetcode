package GFG.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Practice {
    public Node LCA(Node root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(root.key == n1 || root.key == n2) {
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if(leftLCA!=null && rightLCA!=null) {
            return root;
        }

        if(leftLCA != null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(50);
        node.right = new Node(60);

        node.left.left = new Node(70);
        node.left.right = new Node(20);

        node.left.left.left = new Node(40);
        node.left.right.left = new Node(90);
        node.left.right.right = new Node(80);
        node.left.right.left.left = new Node(30);

        Practice lca = new Practice();
        System.out.println(lca.LCA(node, 30, 80).key);

    }
}
