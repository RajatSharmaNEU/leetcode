package GFG.Graph.NeetCode;

import java.util.Arrays;

public class RedundantConnection {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;
        parent = new int[V + 1];

        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (find(x) == find(y)) {
                return edges[i];
            }

            union(x, y);
        }

        return new int[2];
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2}, {1, 3}, {2, 3}
        };

        RedundantConnection rc = new RedundantConnection();
        int[] result = rc.findRedundantConnection(edges);

        System.out.println(Arrays.toString(result));
    }
}
