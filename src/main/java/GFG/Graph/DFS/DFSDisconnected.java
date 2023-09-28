package GFG.Graph.DFS;

import java.util.ArrayList;

public class DFSDisconnected {
    static public void DFSRec(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited) {
        visited[S] = true;
        System.out.println(S + "");

        for(int u: adj.get(S)) {
            if(visited[u] == false) {
                DFSRec(adj, u, visited);
            }
        }
    }

    static public void DFSDisconnect(ArrayList<ArrayList<Integer>> adj, int V, int S) {
        int count = 0;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(visited[i] == false) {
                DFSRec(adj, i, visited);
                count++;
            }
        }
        System.out.println("Disconnected Graphs - " + count);
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
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 3, 4);

//        printGraph(adj);

        DFSDisconnect(adj, 5, 0);
    }
}
