package GFG.Graph;

import java.util.ArrayList;
import java.util.Arrays;

// KosaRaju Algorithm - https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
public class StronglyConnected {
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    static int V = 5;

    public static void DFSRecursive(int n, boolean[] visited) {
        visited[n] = true;

        for (int v: adjList.get(n)) {
            if(!visited[v]) {
                DFSRecursive(v, visited);
            }
        }
    }

    public static void transpose() {
        ArrayList<ArrayList<Integer>> newAdjList = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            newAdjList.add(new ArrayList<>());
        }

        for (int i = 0; i < adjList.size(); i++) {
            for (int v: adjList.get(i)) {
                newAdjList.get(v).add(i);
            }
        }

        adjList = newAdjList;
    }

    public static boolean isSC() {
        boolean[] visited = new boolean[V];
        DFSRecursive(0, visited);
        for (boolean node: visited) {
            if(!node) {
                return false;
            }
        }

        Arrays.fill(visited, false);

        transpose();

        DFSRecursive(0, visited);
        for (boolean node: visited) {
            if(!node) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(3);
        adjList.get(3).add(0);
        adjList.get(2).add(4);
//        adjList.get(4).add(2);

        System.out.print(isSC());
    }
}
