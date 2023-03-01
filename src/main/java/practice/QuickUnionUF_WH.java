package practice;

public class QuickUnionUF_WH {
    private int[] parent;
    private int[] height;

    public QuickUnionUF_WH(int N) {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            height[i] = 1;
        }
    }

    private int find(int i) {
        while (i != parent[i]) {
            // Path Compression
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if (i == j) return;

        if(height[i] < height[j]) {
            parent[i] = j;
            height[j] = height[j] + height[i];
        } else {
            parent[j] = i;
            height[i] = height[j] + height[i];
        }
    }
}
