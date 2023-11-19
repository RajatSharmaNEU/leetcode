package Graph.Practice.Nov;

import java.util.ArrayList;
import java.util.List;

public class GoodPath {
    public int count = 0;
    public int initialCount = 0;

    public void DFSRecursive(List<List<Integer>> adj, int[] vals, int v, boolean[] visited, int val) {
        visited[v] = true;
        for (int u : adj.get(v)) {
            if (visited[u] == false) {

                if (vals[u] == val) {
                    count++;
                }
                if (vals[u] <= val) {
                    DFSRecursive(adj, vals, u, visited, val);
                }
            }
        }
    }


    public void DFS(List<List<Integer>> adj, int[] vals, int s, int val) {
        boolean[] visited = new boolean[adj.size()];
        DFSRecursive(adj, vals, s, visited, val);
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vals.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        initialCount = vals.length;
        for (int i = 0; i < vals.length; i++) {
            DFS(adj, vals, i, vals[i]);
        }

        return initialCount + (count/2);
    }

    public static void main(String[] args) {
//        int[] vals = new int[]{1, 3, 2, 1, 3};
//        int[][] edges = new int[][]{
//                {0, 1},
//                {0, 2},
//                {2, 3},
//                {2, 4}
//        };

        int[] vals = new int[]{1, 1, 2, 2, 3};
        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {2, 4}
        };

        GoodPath goodPath = new GoodPath();
        System.out.println(goodPath.numberOfGoodPaths(vals, edges));
    }
}
