package GFG.DisjointSet;

import java.util.Arrays;

public class Practice {
    static int[] parent;

    public static void initialize(int[] arr) {
        parent = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX == parentY) {
            return;
        }

        parent[find(parentY)] = parentX;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4};

        initialize(arr);
        union(0, 2);
        union(2, 4);

        System.out.println(Arrays.toString(parent));
        System.out.println(find(4));
        System.out.println(find(0));
    }
}
