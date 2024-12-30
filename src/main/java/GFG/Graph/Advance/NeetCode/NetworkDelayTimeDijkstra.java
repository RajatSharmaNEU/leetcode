package GFG.Graph.Advance.NeetCode;

import java.util.*;

public class NetworkDelayTimeDijkstra {

    public static int findLongestTime(int[][] times, int n, int k) {
        /// Step 1 - Create adjList
        // Initialize adjacency list using HashMap
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        // Populate adjacency list with edges and weights
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            adjList.get(u).add(new int[]{v, w});
        }

        /// PriorityQueue of data - [time, node]

        // Min-heap (Priority Queue) to process nodes by shortest time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, k});  // {time, node}

        // Set to track visited nodes
        Set<Integer> visited = new HashSet<>();
        int time = 0;

        // BFS Traversal
        // Process while the heap is not empty and we haven't visited all nodes
        while (!minHeap.isEmpty() && visited.size() < n) { //
            int[] current = minHeap.poll();
            int currTime = current[0], node = current[1];

            // Skip if the node is already visited
            if (!visited.contains(node)) {
                // Mark the node as visited
                visited.add(node);
                time = Math.max(time, currTime);

                // Traverse the neighbors of the current node
                for (int[] neighbor : adjList.get(node)) {
                    int nextNode = neighbor[0], edgeWeight = neighbor[1];
                    if (!visited.contains(nextNode)) {
                        minHeap.offer(new int[]{currTime + edgeWeight, nextNode});
                    }
                }
            }
        }

        // If all nodes are visited, return the total time, otherwise return -1
        return visited.size() == n ? time : -1;
    }

    static class Pair {
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }

    private static int findLongestTimeUsingDist(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        int dis[] = new int[n + 1];
        Arrays.fill(dis, (int) (1e9));

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(k, 0));
        dis[k] = 0;

        while (!pq.isEmpty()) {
            Pair currPair = pq.poll();
            int nodeIndex = currPair.node;
            int weight = currPair.wt;
            for (Pair it : adj.get(nodeIndex)) {
                int Node = it.node;
                int we = it.wt;
                if (dis[Node] > dis[nodeIndex] + we) {
                    dis[Node] = dis[nodeIndex] + we;
                    pq.add(new Pair(Node, dis[Node]));
                }
            }
        }
        int m = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == (1e9)) return -1;
            m = Math.max(m, dis[i]);
        }
        return m;
    }

    public static void main(String[] args) {
        int[][] nodes1 = new int[][]{
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
        System.out.println(findLongestTime(nodes1, 4, 2) == 2);
        System.out.println(findLongestTime(nodes2, 5, 3) == 59);

    }
}
