package GFG.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathByBFS {
    static int[] BFSSolution(ArrayList<ArrayList<Integer>> adj, int V, int S) {
        int[] dist = new int[V];
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        dist[S] = 0;
        visited[S] = true;
        q.add(S);

        while (q.isEmpty() == false) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (visited[v] == false) {
                    dist[v] = dist[u] + 1;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        return dist;
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

    static void printDist(int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            System.out.println("Dist from 0 to " + i + " is " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);

//        printGraph(adj);

        int[] dist = BFSSolution(adj, V, 0);
        printDist(dist);
    }
}
