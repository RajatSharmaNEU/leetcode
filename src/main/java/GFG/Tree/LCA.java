package GFG.Tree;

import java.util.ArrayList;

public class LCA {
    public Node LCA(Node root, int n1, int n2) {
        if(root == null) return null;

        if(root.key == n1 || root.key == n2) {
            return root;
        }

        Node leftLCA = LCA(root.left, n1, n2);
        Node rightLCA = LCA(root.right, n1, n2);

        if(leftLCA != null && rightLCA !=null) {
            return root;
        }

        if(leftLCA!=null) {
            return leftLCA;
        } else {
            return rightLCA;
        }
    }

    public boolean getAncestor(Node node, ArrayList<Node> ancestors, int key) {
        if (node == null) return false;

        ancestors.add(node);

        if(node.key == key || getAncestor(node.left, ancestors, key) || getAncestor(node.right, ancestors, key)) {
            return true;
        }

        ancestors.remove(ancestors.size() - 1);

        return false;
    }

    public void naiveSolution(Node node, int n1, int n2) {
        ArrayList<Node> ancestors1 = new ArrayList<>();
        ArrayList<Node> ancestors2 = new ArrayList<>();

        this.getAncestor(node, ancestors1, n1);
        this.getAncestor(node, ancestors2, n2);

        for (int i = 0; i < ancestors1.size() && i < ancestors2.size(); i++) {
            if(ancestors1.get(i+1).key != ancestors2.get(i+1).key) {
                System.out.println(ancestors1.get(i).key);
                break;
            }
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

        LCA lca = new LCA();
        lca.naiveSolution(node, 30, 80);
        System.out.println(lca.LCA(node, 30, 80).key);

    }
}
