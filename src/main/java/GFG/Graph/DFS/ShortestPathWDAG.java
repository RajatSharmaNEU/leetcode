package GFG.Graph.DFS;

import java.util.*;

// Java program to find single source shortest paths
// in a Directed Acyclic Graph (DAG).
public class ShortestPathWDAG {
    static int V;
    static final int INF = Integer.MAX_VALUE;

    static class Node {
        int v;
        int wt;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    static void addEdge(int u, int v, int wt) {
        adj.get(u).add(new Node(v, wt));
    }

    static ArrayList<ArrayList<Node>> adj;

    // Function to find topological Sort which is always possible
    // as the given graph is a DAG.
    static void topologicalSort(int v, boolean visited[], Stack<Integer> st) {
        visited[v] = true;
        for (Node node : adj.get(v)) {
            if (!visited[node.v]) {
                topologicalSort(node.v, visited, st);
            }
        }
        st.push(v);
    }

    // Function to compute the shortest path
    // to all other vertices starting from src.
    static void shortestPath(int src) {
        Stack<Integer> st = new Stack<>();

        int dist[] = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, visited, st);
            }
        }

        // Distance Optimization
        while (!st.isEmpty()) {
            int u = st.pop();
            System.out.println("S - " + u);
            for (Node node : adj.get(u)) {
                if (dist[node.v] > dist[u] + node.wt)
                    dist[node.v] = dist[u] + node.wt;
            }
        }

        // Print the distances.
        for (int i = 0; i < V; i++) {
            if (dist[i] == INF)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }

    }

    // Main function
    public static void main(String args[]) {
        V = 6;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Add edges.
        addEdge(0, 1, 2);
        addEdge(0, 4, 1);
        addEdge(1, 2, 3);
        addEdge(2, 3, 6);
        addEdge(4, 2, 2);
        addEdge(4, 5, 4);
        addEdge(5, 3, 1);
        shortestPath(0);
    }
}
