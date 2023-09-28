package GFG.Graph.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph {

    // Kahn's Algorithm
    static public boolean BFS(ArrayList<ArrayList<Integer>> adj, int V){
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int v: adj.get(i)){
                inDegree[v]++;
            }
        }

        // Create and add 0 inDegree element
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()){
            int v = q.poll();

            for (int u: adj.get(v)) {
                inDegree[u]--;
                if(inDegree[u] == 0) {
                    q.add(u);
                }
            }

            count++;
        }

        return count!=V;
    }

    static public boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited, boolean[] parentStack) {
        visited[S] = true;
        parentStack[S] = true;
//        System.out.println(S + "");

        for(int u: adj.get(S)) {
            if(visited[u] == false) {
                if(DFSRec(adj, u, visited, parentStack) == true) {
                    return true;
                }
            } else if (parentStack[u] == true) {
                return true;
            }
        }


        parentStack[S] = false;
        return false;
    }

    static public boolean DFS(ArrayList<ArrayList<Integer>> adj, int V, int S) {
        boolean[] visited = new boolean[V];
        boolean[] parentStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(visited[i] == false) {
                if(DFSRec(adj, i, visited, parentStack) == true) {
                    return true;
                }
            }
        }

        return false;
    }



    static void addDirectedEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
//        adj.get(v).add(u);
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
        addDirectedEdge(adj, 4, 1);
        addDirectedEdge(adj, 1, 2);
        addDirectedEdge(adj, 2, 3);
        addDirectedEdge(adj, 3, 1);


        System.out.println(DFS(adj, V, 0));
        System.out.println(BFS(adj, V));
    }
}
