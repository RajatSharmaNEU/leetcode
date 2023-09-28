package GFG.Graph.DFS;

import java.util.Arrays;

// MST is for undirected cyclic graph
public class MST {
    // key[] holds minimum weight between adjacent vertex
    // mSet holds vertices visited
    // u variable holds count of vertices includes
    // Time Complexity - Theta(V^2)
    public static int PRIM(int graph[][], int S) {
        int V = graph.length;
        int key[] = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[S] = 0;

        boolean[] mSet = new boolean[V];
        int res = 0;

        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }

            mSet[u] = true;
            res = res + key[u];

            for (int v = 0; v < V; v++) {
                if (!mSet[v] && graph[u][v] != 0) {
                    key[v] = Math.min(key[v], graph[u][v]);
                }
            }
            System.out.println("u - " + u + ", key[] - " + key[0] + ", " + key[1] + ", " + key[2] + ", " + key[3] + ", " +
                    " mSet[] - " + mSet[0] + ", " + mSet[1] + ", " + mSet[2] + ", " + mSet[3] + "");
        }

        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + key[i]);

        return res;
    }

    // dist[] holds minimum weight from source
    // fin[] holds vertices visited/fixed
    // u variable holds the index of vertex
    // Time Complexity - Theta(V^2)
    public static int DIJKSTRA(int graph[][], int S) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        boolean fin[] = new boolean[V]; // Finalize array
        for (int count = 0; count < V-1; count++) {
            // Find next vertex with minimum shortest path
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!fin[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            fin[u] = true;
            // Update adjacent vertex dist from vertex u.
            for (int v = 0; v < V; v++) {
                if (!fin[v] && graph[u][v] != 0) {
                    dist[v] = Math.min(dist[v], dist[u] + graph[u][v]);
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);

        return dist[V-1];
    }

    public static void main(String[] args) {
        int V = 4;
        int graph[][] = new int[V][V];
//        graph[0] = new int[]{0, 5, 8, 0};
//        graph[1] = new int[]{5, 0, 10, 15};
//        graph[2] = new int[]{8, 10, 0, 20};
//        graph[3] = new int[]{0, 15, 20, 0};

        graph[0] = new int[]{0, 50, 100, 0};
        graph[1] = new int[]{50, 0, 30, 200};
        graph[2] = new int[]{100, 30, 0, 20};
        graph[3] = new int[]{0, 200, 20, 0};

        int res = PRIM(graph, 0);
        System.out.println("MST using PRIM - " + res);
        int dist = DIJKSTRA(graph, 0);
        System.out.println("MST using DIJKSTRA - " + dist);
    }
}
