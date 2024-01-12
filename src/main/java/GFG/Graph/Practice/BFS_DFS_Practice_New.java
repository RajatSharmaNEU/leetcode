package GFG.Graph.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_Practice_New {
    public static boolean BFS(ArrayList<ArrayList<Integer>> adj, int S) {
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            for (int u : adj.get(i)) {
                inDegree[u]++;
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }


        int count = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int u : adj.get(v)) {
                inDegree[u]--;

                if (inDegree[u] == 0) {
                    queue.add(u);
                }
            }
            count++;
        }

        return count != adj.size();
    }

    public static boolean BFSDetectCycle(ArrayList<ArrayList<Integer>> adj, int S) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        Integer[] parent = new Integer[adj.size()];
        Arrays.fill(parent, -1);

        queue.add(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
//            System.out.println(v);
            for (int u : adj.get(v)) {
                if (!visited[u]) {
                    visited[u] = true;
                    queue.add(u);
                    parent[u] = v;
                } else if (parent[v] != u) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean DFSRecursive(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v, boolean[] parent) {
        visited[v] = true;
        parent[v] = true;

        for (int u : adj.get(v)) {
            if (!visited[u] && DFSRecursive(adj, visited, u, parent)) {
                return true;
            } else if (parent[u]) {
                return true;
            }
        }


        parent[v] = false;
        return false;
    }

    public static boolean DFS(ArrayList<ArrayList<Integer>> adj, int S) {
        boolean[] visited = new boolean[adj.size()];
        boolean[] parent = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if(visited[i] == false && DFSRecursive(adj, visited, S, parent)) {
                return true;
            }
        }
        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int edge1, int edge2) {
        adj.get(edge1).add(edge2);
//        adj.get(edge2).add(edge1);
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

//        addEdge(adj, 0, 1);
//        addEdge(adj, 0, 2);
//
//        addEdge(adj, 1, 3);
//        addEdge(adj, 1, 4);
//
//        addEdge(adj, 2, 5);
//        addEdge(adj, 2, 6);

        addEdge(adj, 0, 1);
        addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 5, 3);

        BFS(adj, 0);
        System.out.println(BFS(adj, 0));
        System.out.println(DFS(adj, 0));
//        DFS(adj, 0);

    }
}
