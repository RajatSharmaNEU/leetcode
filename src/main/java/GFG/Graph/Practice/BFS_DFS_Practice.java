package GFG.Graph.Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Practice {
    public static void BFS(ArrayList<ArrayList<Integer>> adj, int S) {
        int[] dist = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];

        visited[S] = true;
        q.add(S);
        dist[S] = 0;

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.print(v);

            for (int u : adj.get(v)) {
                if (visited[u] == false) {
                    visited[u] = true;
                    q.add(u);
                    dist[u] = dist[v] + 1;
                }
            }
        }

        System.out.println("\n");
        System.out.print("Distance - ");
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]);
        }
    }

    public static void DFSRecursive(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited) {
        visited[S] = true;
        System.out.print(S);

        for (int u : adj.get(S)) {
            if (visited[u] == false) {
                DFSRecursive(adj, u, visited);
            }
        }
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int S) {
        boolean[] visited = new boolean[adj.size()];
        DFSRecursive(adj, S, visited);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        // Step1. Create Adjacency List
        // Step2. BFS Solution - Visited Array + Queue + Iterative While Loop
        // Step3. DFS Solution - Visited Array + Recursive

        // Connected Graph
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);

        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 5);
        addEdge(adj, 2, 6);

        System.out.print("BFS Output - ");
        BFS(adj, 0);
        System.out.println("\n");
        System.out.print("DFS Output - ");
        DFS(adj, 0);

    }
}
