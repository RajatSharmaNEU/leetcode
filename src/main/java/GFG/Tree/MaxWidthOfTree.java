package GFG.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfTree {
    public int maxWidth(Node node) {
        if (node == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        int result = 0;
        while (!q.isEmpty()) {
            int count = q.size();
            result = Math.max(result, count);

            for (int i = 0; i < count; i++) {
                Node curr = q.poll();
                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(20);
        node.right = new Node(30);
        node.left.left = new Node(40);
        node.right.left = new Node(50);
        node.right.right = new Node(60);
        node.left.left.left = new Node(80);

        MaxWidthOfTree maxWidthOfTree = new MaxWidthOfTree();
        System.out.println(maxWidthOfTree.maxWidth(node));
    }
}
