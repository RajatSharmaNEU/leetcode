package GFG.Graph.NeetCode;

import java.util.*;

public class GraphValidTree {
    public static boolean isValidTree(int V, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for(int v: adjList.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    queue.add(v);
                } else if (parent[u] != v) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] edgesA = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        };

        int[][] edgesB = new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        };
        System.out.println(isValidTree(5, edgesA));
        System.out.println(isValidTree(5, edgesB));
    }
}
