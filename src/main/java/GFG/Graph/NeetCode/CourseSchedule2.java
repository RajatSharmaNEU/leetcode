package GFG.Graph.NeetCode;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            adjList.get(u).add(v);

            inDegree[v]++;
        }

        List<Integer> order = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.add(v);

            for (int u : adjList.get(v)) {
                inDegree[u]--;

                if (inDegree[u] == 0) {
                    queue.add(u);
                }
            }
        }

        return numCourses == order.size() ? order.stream().mapToInt(i->i).toArray() : new int[0];
    }

    public static void main(String[] args) {
        int[][] prerequisites1 = new int[][]{{1, 0}, {0, 1}};
        int[][] prerequisites2 = new int[][]{{1, 0}};

        CourseSchedule2 courseSchedule = new CourseSchedule2();
        System.out.println(Arrays.toString(courseSchedule.findOrder(2, prerequisites1)));
        System.out.println(Arrays.toString(courseSchedule.findOrder(2, prerequisites2)));
    }
}
