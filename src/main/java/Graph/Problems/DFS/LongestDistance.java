package Graph.Problems.DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestDistance {
    int max = 0;
    int root = -1;

    public void DFSRec(ArrayList<ArrayList<Integer>> adj, int S, boolean[] visited, int count) {
        visited[S] = true;
        for (int u : adj.get(S)) {
            if (visited[u] == false) {
                DFSRec(adj, u, visited, count + 1);
            }
        }

        if (count > max) {
            max = count;
            root = S;
        }
    }

    public int solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == -1) {
                root = i;
            } else {
                adj.get(A.get(i)).add(i);
                adj.get(i).add(A.get(i));
            }
        }

        if (adj.size() == 1) {
            return 0;
        }

        if (adj.size() == 2) {
            return 1;
        }

        // call to find the longest distance from root
        DFS(adj, root);

        // call to find the longest distance from far element
        max = 0;
        DFS(adj, root);
        return max;
    }

    public void DFS(ArrayList<ArrayList<Integer>> adj, int S) {
        boolean[] visited = new boolean[adj.size()];
        DFSRec(adj, S, visited, 0);
    }

    public static void main(String[] args) {
//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 0, 0, 3));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 1, 1, 2, 0, 5, 0, 3, 0, 0, 2, 3, 1, 12, 14, 0, 5, 9, 6, 16, 0, 13, 4, 17, 2, 1, 22, 14, 20, 10, 17, 0, 32, 15, 34, 10, 19, 3, 22, 29, 2, 36, 16, 15, 37, 38, 27, 31, 12, 24, 29, 17, 29, 32, 45, 40, 15, 35, 13, 25, 57, 20, 4, 44, 41, 52, 9, 53, 57, 18, 5, 44, 29, 30, 9, 29, 30, 8, 57, 8, 59, 59, 64, 37, 6, 54, 32, 40, 26, 15, 87, 49, 90, 6, 81, 73, 10, 8, 16));
        LongestDistance ld = new LongestDistance();
        System.out.println(ld.solve(A));
    }
}
