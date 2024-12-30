package GFG.Graph.Advance.NeetCode;

import java.util.Arrays;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        // initialize an array with max value of size n
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < times.length; j++) {
                int u = times[j][0]; // source
                int v = times[j][1]; // target
                int wt = times[j][2]; // time

                if (dist[u - 1] != Integer.MAX_VALUE &&
                        dist[u - 1] + wt < dist[v - 1]) {
                    dist[v - 1] = dist[u - 1] + wt;
                }
            }

        }

        int result = Integer.MIN_VALUE;

        // calculate max value
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, dist[i]);
        }

        // return result
        return result;
    }

    public static void main(String[] args) {
        int[][] nodes = new int[][]{
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        };

        int[][] nodes2 = new int[][]{
                {4, 2, 76},
                {1, 3, 79},
                {3, 1, 81},
                {4, 3, 30},
                {2, 1, 47},
                {1, 5, 61},
                {1, 4, 99},
                {3, 4, 68},
                {3, 5, 46},
                {4, 1, 6},
                {5, 4, 7},
                {5, 3, 44},
                {4, 5, 19},
                {2, 3, 13},
                {3, 2, 18},
                {1, 2, 0},
                {5, 1, 25},
                {2, 5, 58},
                {2, 4, 77},
                {5, 2, 74}
        };

        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(nodes, 4, 2) == 2);
        System.out.println(networkDelayTime.networkDelayTime(nodes2, 5, 3) == 59);
    }
}
