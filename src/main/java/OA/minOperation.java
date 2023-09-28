package OA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-operations-to-make-network-connected/submissions/1029446377/

// Minimum operation required to connect all computer

public class minOperation {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s, int d) {
        adj.get(s).add(d);
        adj.get(d).add(s);
    }

    static int connectionUsed = 0;

    public static void BFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int src) {
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int u : adj.get(v)) {
                if (visited[u] == false) {
                    visited[u] = true;
                    q.add(u);
                    connectionUsed++;
                }
            }
        }
    }

    public static int makeConnected(int n, int[][] connections) {
        // first calculate minimum connection required in existing graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < connections.length; i++) {
            addEdge(adj, connections[i][0], connections[i][1]);
        }

        boolean[] visited = new boolean[adj.size()];
        int countDisconnectedGraph = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                BFS(adj, visited, i);
                countDisconnectedGraph++;
            }
        }

//         System.out.println("countDisconnectedGraph -"  + countDisconnectedGraph);
//         System.out.println("connectionUsed -" + connectionUsed);

        if (connections.length - connectionUsed >= countDisconnectedGraph - 1) {
            return countDisconnectedGraph - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int[][] connections1 = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(makeConnected(n1, connections1));

        connectionUsed = 0;
        int n2 = 6;
        int[][] connections2 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        System.out.println(makeConnected(n2, connections2));
    }
}
