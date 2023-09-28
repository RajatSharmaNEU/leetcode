package GFG.Graph.Practice;

import java.util.*;

public class Practice9thSept {
    static class Node {
        int v;
        int wt;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<ArrayList<Node>> adj, int s, int d, int wt) {
        adj.get(s).add(new Node(d, wt));
    }

    public static void topologicalSort(ArrayList<ArrayList<Node>> adj, int s, boolean[] visited, Stack<Integer> st) {
        visited[s] = true;
        for (Node node : adj.get(s)) {
            if (visited[node.v] == false) {
                topologicalSort(adj, node.v, visited, st);
            }
        }

        st.push(s);
    }

    public static void shortestPath(ArrayList<ArrayList<Node>> adj, int S) {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == false) {
                topologicalSort(adj, i, visited, st);
            }
        }

        int dist[] = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        while (!st.isEmpty()) {
            int v = st.pop();
            System.out.println(v);
            for (Node node : adj.get(v)) {
                if (dist[node.v] > dist[v] + node.wt) {
                    dist[node.v] = dist[v] + node.wt;
                }
            }
        }

        // Print the distances.
        for (int i = 0; i < adj.size(); i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
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

        shortestPath(adj, 0);
    }
}
