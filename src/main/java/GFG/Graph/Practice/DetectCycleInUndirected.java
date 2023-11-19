package GFG.Graph.Practice;

import GFG.Graph.DFS.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInUndirected {
    public static boolean BFSSolution(ArrayList<ArrayList<Integer>> adj, int S) {
        boolean[] visited = new boolean[adj.size()];
        int[] parent = new int[adj.size()];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();

        q.add(S);
        visited[S] = true;
        parent[S] = -1;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int u : adj.get(v)) {
                if (visited[u] == false) {
                    visited[u] = true;
                    q.add(u);
                    parent[u] = v;
                } else if (parent[v] != u) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean DFSRecursive(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, int parent) {
        visited[v] = true;
        System.out.println(v);
        for (int u : adj.get(v)) {
            if (visited[u] == false) {
                return DFSRecursive(adj, u, visited, v);
            } else if (parent != u) {
                return true;
            }
        }

        return false;
    }

    public static boolean DFSSolution(ArrayList<ArrayList<Integer>> adj, int S) {
        boolean[] visited = new boolean[adj.size()];
        return DFSRecursive(adj, S, visited, -1);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

//        printGraph(adj);

        System.out.println("Using DFS - " + DFSSolution(adj, 0));
//        System.out.println("Using BFS - " + BFSSolution(adj, 0));
    }
}
