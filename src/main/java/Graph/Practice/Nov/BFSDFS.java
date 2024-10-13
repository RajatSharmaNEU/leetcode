package Graph.Practice.Nov;

import java.util.*;

public class BFSDFS {
    static void topologicalSort(int s, Stack<Integer> stack, boolean[] visited) {
        visited[s] = true;

        for (Node n : adj.get(s)) {
            if (!visited[n.v]) {
                topologicalSort(n.v, stack, visited);
            }
        }

        stack.push(s);
    }

    static void shortestPath(int src) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == false) {
                topologicalSort(i, stack, visited);
            }
        }

        // Distance Optimization
        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (Node node : adj.get(u)) {
                dist[node.v] = Math.min(dist[node.v], dist[u] + node.wt);
            }
        }

        System.out.println(Arrays.toString(dist));
    }


    static class Node {
        int v;
        int wt;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    static void addDirectedEdge(int u, int v, int wt) {
        adj.get(u).add(new Node(v, wt));
    }

    public static void main(String[] args) {
        int V = 6;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Node>());
        }

        addDirectedEdge(0, 1, 2);
        addDirectedEdge(0, 4, 1);
        addDirectedEdge(1, 2, 3);
        addDirectedEdge(2, 3, 6);
        addDirectedEdge(4, 2, 2);
        addDirectedEdge(4, 5, 4);
        addDirectedEdge(5, 3, 1);

        shortestPath(0);
    }
}
