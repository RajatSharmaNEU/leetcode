package GFG.DisjointSet;

import java.util.Arrays;

public class UnionFind {
    public static int[] parent;

    public static void initialize(int[] arr) {
        parent = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // if both are of same set, not need to update
        if (rootX == rootY) {
            return;
        }
//        parent[rootY] = rootX;
        parent[find(rootY)] = rootX;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4};
        initialize(arr);
        union(0, 2);
        union(2, 4);

        System.out.println(Arrays.toString(parent));
        System.out.println(find(4));
    }
}
