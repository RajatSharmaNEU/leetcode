package GFG.Graph.NeetCode;

import java.util.*;

public class AlienDictionary {
    public static String getOrder(String[] words) {
        // Step 1 - Create graph and inDegree
        // use HashMap as key is character

        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();

        // Step 2 - Initialize and build graph

        // Initialize
        for (String word: words) {
            for(char c: word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, 0);
            }
        }

        // Build
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if(word1.length() > word2.length() && word2.startsWith(word1)) {
                System.out.println("Invalid Dictionary");
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if(c1 != c2) {
                    if(!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                }
            }
        }

        // Step 2 - Topological Sort to find result
        StringBuilder result = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (char c: inDegree.keySet()) {
            if(inDegree.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char curr = queue.poll();
            result.append(curr);

            for (char nextChar : graph.get(curr)) {
                inDegree.put(nextChar, inDegree.get(nextChar) - 1);

                if(inDegree.get(nextChar) == 0) {
                    queue.add(nextChar);
                }
            }
        }


        // If the result length is less than the total number of unique characters, there's a cycle
        if (result.length() < inDegree.size()) {
            return "";
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(getOrder(words));
    }
}
