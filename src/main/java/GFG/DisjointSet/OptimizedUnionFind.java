package GFG.DisjointSet;

import java.util.Arrays;

public class OptimizedUnionFind {
    public static int[] parent, rank;
    public static void initialize(int[] arr) {
        parent = new int[arr.length];
        rank = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public static int findByPathCompression(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = findByPathCompression(parent[x]);

        return parent[x];
    }

    public static void unionByRank(int x, int y) {
        int rootX = findByPathCompression(x);
        int rootY = findByPathCompression(y);
        // if both are of same set, not need to update
        if (rootX == rootY) {
            return;
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4};
        initialize(arr);
        unionByRank(0, 2);
        unionByRank (2,4);

        System.out.println(Arrays.toString(parent));
        System.out.println(findByPathCompression(4));
    }
}
