package GFG.DisjointSet;

import java.util.Arrays;

public class MinimumSpanningTree {
    public static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static int kruskalMST(Edge[] edges, int V) {
        Edge[] mst = new Edge[V - 1];

        // Arrange Edge from less to high weight
        Arrays.sort(edges);
        // Use Disjoint Set to manage union of edge that will be in MST
        OptimizedUnionFind.initialize(new int[V]);

        // Add edge in MST if vertices of edge are different
        for (int i = 0, s = 0; s < V - 1; i++) {
            Edge edge = edges[i];
            int x = OptimizedUnionFind.findByPathCompression(edge.start);
            int y = OptimizedUnionFind.findByPathCompression(edge.end);
            if (x != y) {
                mst[s++] = edge;
                OptimizedUnionFind.unionByRank(x, y);
            }
        }

        int result = 0;
        for (Edge edge : mst) {
            result += edge.weight;
        }
        return result;
    }

    public static void main(String[] args) {
        Edge[] edges = new Edge[]{
                new Edge(1, 3, 3),
                new Edge(2, 3, 4),
                new Edge(1, 2, 5),
                new Edge(0, 2, 8),
                new Edge(0, 1, 10),
                new Edge(2, 4, 12),
                new Edge(3, 4, 15)
        };

        System.out.println("MST total weight will be " + kruskalMST(edges, 5));
    }
}
