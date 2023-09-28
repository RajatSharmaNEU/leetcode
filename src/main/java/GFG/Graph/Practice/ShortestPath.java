package GFG.Graph.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPath {
    // Topological Sort using DFS

    public static void DFSTopologicalSort(ArrayList<ArrayList<Node>> adj, boolean[] visited, Stack<Integer> stack, int src) {
        visited[src] = true;

        for (Node n : adj.get(src)) {
            if (visited[n.d] == false) {
                DFSTopologicalSort(adj, visited, stack, n.d);
            }
        }

        stack.add(src);
    }

    public static void Solution(ArrayList<ArrayList<Node>> adj, int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        int[] dist = new int[adj.size()];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == false) {
                DFSTopologicalSort(adj, visited, stack, i);
            }
        }

        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (Node n : adj.get(u)) {
                if (dist[n.d] > n.wt + dist[u]) {
                    dist[n.d] = n.wt + dist[u];
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static class Node {
        int d;
        int wt;

        Node(int d, int wt) {
            this.d = d;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<ArrayList<Node>> adj, int s, int d, int wt) {
        adj.get(s).add(new Node(d, wt));
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges.
        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 4, 1);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 2, 3, 6);
        addEdge(adj, 4, 2, 2);
        addEdge(adj, 4, 5, 4);
        addEdge(adj, 5, 3, 1);

        Solution(adj, 0); // 0 2 3 6 1 5
    }
}
