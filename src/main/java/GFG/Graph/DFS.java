package GFG.Graph;

import java.util.ArrayList;

public class DFS {
    static public void DFSRec(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited) {
        visited[S] = true;
        System.out.println(S + "");

        for(int u: adj.get(S)) {
            if(visited[u] == false) {
                DFSRec(adj, u, visited);
            }
        }
    }

    static public void DFS(ArrayList<ArrayList<Integer>> adj, int V, int S) {
        boolean[] visited = new boolean[V];
        DFSRec(adj, S, visited);
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
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

//        printGraph(adj);

        DFS(adj, 5, 0);
    }
}
