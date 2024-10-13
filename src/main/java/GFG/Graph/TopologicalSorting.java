package GFG.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Works only if there is no cycle
public class TopologicalSorting {
    static void BFSSolution(ArrayList<ArrayList<Integer>> adj, int V, int S) {
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.println(v);

            for (int u : adj.get(v)) {
                inDegree[u]--;

                if (inDegree[u] == 0) {
                    q.add(u);
                }
            }
        }
    }

    public static void DFSRec(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited, Stack stack) {
        visited[S] = true;

        for (int u : adj.get(S)) {
            if (visited[u] == false) {
                DFSRec(adj, u, visited, stack);
            }
        }

        stack.add(S);
    }

    public static void DFS(ArrayList<ArrayList<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFSRec(adj, i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            int e = stack.pop();
            System.out.println(e);
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
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

//        addEdge(adj, 0, 1);
//        addEdge(adj, 1, 3);
//        addEdge(adj, 2, 3);
//        addEdge(adj, 2, 4);
//        addEdge(adj, 3, 4);

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 4, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);



//        printGraph(adj);

        BFSSolution(adj, V, 0);
//        System.out.println("");
//        DFS(adj, V);
    }
}
