package GFG.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintSpiral {
    public void printOrder(Node node) {
        if(node == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        boolean reverse = false;
        Stack<Integer> stack = new Stack<>();

        while (!q.isEmpty()){
            int count = q.size();
            for (int i = 0; i < count; i++) {
                Node curr = q.poll();

                if (reverse) {
                    stack.push(curr.key);
                } else {
                    System.out.println(curr.key);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            if(reverse){
                while (stack.isEmpty() == false){
                    System.out.println(stack.pop());
                }
            }
            reverse = !reverse;
            System.out.println("-");
        }

    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);

        node.right.left = new Node(6);
        node.right.right = new Node(7);

        PrintSpiral printSpiral = new PrintSpiral();
        printSpiral.printOrder(node);
    }
}
