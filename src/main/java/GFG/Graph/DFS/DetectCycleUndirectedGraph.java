package GFG.Graph.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedGraph {
    static boolean BFSSolution(ArrayList<ArrayList<Integer>> adj, int V, int S) {
        int parent[] = new int[V];
        Arrays.fill(parent, -1);

        boolean visited[] = new boolean[V];
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
                    parent[v] = u; //
                } else if (parent[u] != v) //
                    return true;
            }
        }
        return false;
    }


    static public boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited, int parent) {
        visited[S] = true;

        for (int u : adj.get(S)) {
            if (visited[u] == false) {
                if (DFSRec(adj, u, visited, S) == true) {
                    return true;
                }
            } else if (parent != u) {
                return true;
            }
        }
        return false;
    }

    static public boolean DFS(ArrayList<ArrayList<Integer>> adj, int V, int S) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (DFSRec(adj, S, visited, -1) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + "->");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println("");
        }
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

        System.out.println("Using DFS - " + DFS(adj, V, 0));
        System.out.println("Using BFS - " +  BFSSolution(adj, V, 0) );
    }

}
