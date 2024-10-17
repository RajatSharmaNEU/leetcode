package GFG.Graph.NeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    private boolean BFSConnected(List<List<Integer>> adj) {
        int[] inDegree = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            for (int u : adj.get(i)) {
                inDegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int v = q.poll();

            for (int u : adj.get(v)) {
                inDegree[u]--;

                if (inDegree[u] == 0) {
                    q.add(u);
                }
            }
            count++;
        }

        return count == adj.size();
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        return BFSConnected(adj);

    }

    private boolean canFinishOptimised(int numCourses, int[][] prerequisites) {
        int[] outDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            outDegree[prerequisites[i][1]]++;
        }

        // Now to find starting element which has outDegree == 0
        // we need to loop over prerequisites

        boolean foundStart = true;
        boolean[] visited = new boolean[prerequisites.length]; // Array item visited

        while (foundStart) {
            foundStart = false;

            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i] && outDegree[prerequisites[i][0]] == 0) {
                    visited[i] = true;
                    outDegree[prerequisites[i][1]]--;
                    foundStart = true;
                }
            }
        }

        for (int ele : outDegree) {
            if (ele != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites1 = new int[][]{{1, 0}, {0, 1}};
        int[][] prerequisites2 = new int[][]{{1, 0}};

        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(2, prerequisites1));
        System.out.println(courseSchedule.canFinishOptimised(2, prerequisites1));

        System.out.println(courseSchedule.canFinish(2, prerequisites2));
        System.out.println(courseSchedule.canFinishOptimised(2, prerequisites2));
    }
}
