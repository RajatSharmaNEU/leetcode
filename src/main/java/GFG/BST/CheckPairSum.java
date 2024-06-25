package GFG.BST;

import java.util.HashSet;

public class CheckPairSum {
    public static boolean isPairSum(Node root, int sum, HashSet<Integer> set) {
        if(root == null) {
            return false;
        }

        // left
        if(isPairSum(root.left, sum, set)) {
            return true;
        }

        // curr
        if(set.contains(sum - root.key)) {
            return true;
        } else {
            set.add(root.key);
        }

        // right
        return isPairSum(root.right, sum, set);
    }


    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(9);

        root.right = new Node(20);
        root.right.left = new Node(11);
        root.right.right = new Node(30);
        root.right.right.left = new Node(25);

        HashSet<Integer> hashSet = new HashSet<>();

        System.out.println(isPairSum(root, 33, hashSet));
        System.out.println(isPairSum(root, 32, hashSet));
    }
}
