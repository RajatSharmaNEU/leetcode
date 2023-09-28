package GFG.Graph.Practice;

import java.util.*;

public class TopologicalSort {
    public static void BFSSolution(ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < adj.size(); i++) {
            for(int u: adj.get(i)){
                inDegree[u]++;
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            System.out.println(v);

            for (int u: adj.get(v)) {
                inDegree[u]--;

                if(inDegree[u] == 0) {
                    q.add(u);
                }
            }
        }
    }

    public static void DFSRecursive(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited, Stack<Integer> stack) {
        visited[S] = true;

        for (int u: adj.get(S)) {
            if (visited[u] == false) {
                DFSRecursive(adj, u, visited, stack);
            }
        }

        stack.add(S);
    }
    public static void DFSSolution(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if(visited[i] == false) {
                DFSRecursive(adj, i, visited, stack);
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

    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);
        addEdge(adj, 2, 4);
        addEdge(adj, 3, 4);

//        addEdge(adj, 0, 1);
//        addEdge(adj, 0, 4);
//        addEdge(adj, 1, 2);
//        addEdge(adj, 4, 2);
//        addEdge(adj, 2, 3);
//        addEdge(adj, 4, 5);
//        addEdge(adj, 5, 3);


//        printGraph(adj);

        BFSSolution(adj);
        System.out.println("");
        DFSSolution(adj);
    }
}
