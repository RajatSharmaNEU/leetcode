package Graph.Problems.DFS;

import java.util.ArrayList;
import java.util.Arrays;

public class GoodPath {
    static int result = 0;

    public static void DFSRec(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> adj, int C, int S, boolean[] visited, int count) {
        visited[S] = true;

        if (A.get(S) == 1) {
            count++;
        }

        System.out.print(S + " count-" + count + " C-" + C + ", ");

        for (int u : adj.get(S)) {
            if (visited[u] == false) {
                visited[u] = true;
                DFSRec(A, adj, C, u, visited, count);
                System.out.println();
            }
        }

        if (count <= C && adj.get(S).size() == 1) {
            result++;;
        }
    }

    public static void DFS(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> adj, int C, int S) {
        boolean[] visited = new boolean[A.size()];
        DFSRec(A, adj, C, S, visited, 0);
    }

    public static int solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B, int C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0) - 1;
            int v = B.get(i).get(1) - 1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        DFS(A, adj, C, 0);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        B.add(new ArrayList<>(Arrays.asList(10, 6)));
        B.add(new ArrayList<>(Arrays.asList(3, 2)));
        B.add(new ArrayList<>(Arrays.asList(12, 7)));
        B.add(new ArrayList<>(Arrays.asList(9, 5)));
        B.add(new ArrayList<>(Arrays.asList(2, 1)));

        B.add(new ArrayList<>(Arrays.asList(8, 3)));
        B.add(new ArrayList<>(Arrays.asList(7, 1)));
        B.add(new ArrayList<>(Arrays.asList(4, 2)));
        B.add(new ArrayList<>(Arrays.asList(6, 3)));
        B.add(new ArrayList<>(Arrays.asList(11, 4)));

        B.add(new ArrayList<>(Arrays.asList(5, 3)));
        B.add(new ArrayList<>(Arrays.asList(13, 11)));

        System.out.println(solve(A, B, 7));
    }
}
