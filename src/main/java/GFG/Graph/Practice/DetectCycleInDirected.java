package GFG.Graph.Practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInDirected {
    public static boolean BFSSolution(ArrayList<ArrayList<Integer>> adj, int S) {
        int[] inDegree = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            for (int v: adj.get(i)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()){
            int v = q.poll();

            for (int u: adj.get(v)){
                inDegree[u]--;

                if(inDegree[u] == 0) {
                    q.add(u);
                }
            }
            count++;
        }

        return count!=adj.size();
    }

    public static boolean DFSRecursive(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited, boolean[] parent) {
        visited[S] = true;
        parent[S] = true;

        for (int u : adj.get(S)) {
            if (visited[u] == false) {
                if (DFSRecursive(adj, u, visited, parent)) {
                    return true;
                }
            } else if (parent[u]) {
                return true;
            }
        }

        parent[S] = false;
        return false;
    }

    public static boolean DFSSolution(ArrayList<ArrayList<Integer>> adj, int S) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] parent = new boolean[adj.size()];
        return DFSRecursive(adj, S, visited, parent);
    }

    static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

//        addDirectedEdge(adj, 0, 1);
//        addDirectedEdge(adj, 2, 1);
//        addDirectedEdge(adj, 2, 3);
//        addDirectedEdge(adj, 3, 4);
//        addDirectedEdge(adj, 4, 5);
//        addDirectedEdge(adj, 5, 3);

        addDirectedEdge(adj, 0, 1);
        addDirectedEdge(adj, 1, 2);
        addDirectedEdge(adj, 2, 3);
        addDirectedEdge(adj, 4, 1);
//        addDirectedEdge(adj, 3, 1);

        System.out.println(DFSSolution(adj, 0));
        System.out.println(BFSSolution(adj, 0));
    }
}
