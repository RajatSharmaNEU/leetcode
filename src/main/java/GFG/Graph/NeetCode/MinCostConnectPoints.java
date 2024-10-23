package GFG.Graph.NeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostConnectPoints {
    public int findMinCostConnectPoints(int[][] points) {
        // Create pq - (key, value) -- (weight, index of point)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // sort by weight

        pq.add(new int[] {0, 0});

        Set<Integer> visitedNodes = new HashSet<>();
        int resultedWeight = 0;
        while(visitedNodes.size() < points.length) {
            int[] arr = pq.poll();
            int currWeight = arr[0];
            int currNode = arr[1];

            if(visitedNodes.contains(currNode)) continue;
            resultedWeight += currWeight;
            visitedNodes.add(currNode);

            for (int nextNode = 0; nextNode < points.length; nextNode++) {
                if (!visitedNodes.contains(nextNode)) {
                    int nextWeight =
                            Math.abs(points[nextNode][0] - points[currNode][0]) +
                                    Math.abs(points[nextNode][1] - points[currNode][1]);
                    pq.add(new int[] { nextWeight, nextNode });
                }
            }
        }
        return resultedWeight;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {
                {0,0},
                {2,2},
                {3, 10},
                {5, 2},
                {7, 0}
        };

        int[][] points2 = new int[][] {
                {3,12},{-2,5},{-4,1}
        };

        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
        System.out.println(minCostConnectPoints.findMinCostConnectPoints(points));
        System.out.println(minCostConnectPoints.findMinCostConnectPoints(points2));

    }
}
