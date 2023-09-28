package GFG.Graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDisconnected {
    static void BFSSolution(ArrayList<ArrayList<Integer>> adj, int V, int S, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[S] = true;
        q.add(S);

        while (q.isEmpty() == false) {
            int u = q.poll();
            System.out.println(u + " ");

            for (int v : adj.get(u)) {
                if (visited[v] == false) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    static void BFSDis(ArrayList<ArrayList<Integer>> adj, int V) {
        int count = 0;
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                System.out.println("--");
                BFSSolution(adj, V, i, visited);
                count++;
            }
        }
        System.out.println("Connected Components Count - " + count);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 9;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);

        addEdge(adj, 3, 4);

        addEdge(adj, 5, 6);
        addEdge(adj, 5, 7);
        addEdge(adj, 7, 8);

//        printGraph(adj);

        BFSDis(adj, V);
    }
}
