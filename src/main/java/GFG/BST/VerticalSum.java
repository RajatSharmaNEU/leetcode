package GFG.BST;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    public static void findVerticalSum(Node root, TreeMap<Integer, Integer> map, int key) {
        if(root == null) {
            return;
        }
        findVerticalSum(root.left, map, key - 1);
        map.put(key, map.getOrDefault(key, 0) + root.key);
        findVerticalSum(root.right, map, key + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(15);

        root.left.left = new Node(35);
        root.left.left.left = new Node(40);

        root.left.right = new Node(20);
        root.left.right.right = new Node(75);
        root.left.right.right.right = new Node(80);

        root.right = new Node(25);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        findVerticalSum(root, map, 0);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
    }
}
