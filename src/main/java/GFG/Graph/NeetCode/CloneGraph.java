package GFG.Graph.NeetCode;

import java.util.*;

//https://leetcode.com/problems/clone-graph/
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node getClone(Node node) {
        if (node == null) {
            return node;
        }

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();

        map.put(node, new Node(node.val));
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node child : curr.neighbors) {
                if (!map.containsKey(child)) {
                    map.put(child, new Node(child.val));
                    queue.add(child);
                }
                map.get(curr).neighbors.add(map.get(child));
            }
        }

        return map.get(node);
    }
}
