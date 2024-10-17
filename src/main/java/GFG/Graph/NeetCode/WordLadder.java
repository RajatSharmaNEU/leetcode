package GFG.Graph.NeetCode;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Step 1 - Create HashMap of pattern vs word
        Map<String, List<String>> patterWordMap = new HashMap<>();

        if(!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        for (String word: wordList) {
            StringBuilder pattern = null;
            for (int i = 0; i < word.length(); i++) {
                pattern = new StringBuilder(word);
                pattern.setCharAt(i, '*');

                List<String> patterWordList = patterWordMap.getOrDefault(pattern.toString(), new ArrayList<>());
                patterWordList.add(word);
                patterWordMap.put(pattern.toString(), patterWordList);
            }
        }

        // Step 2 - find endWord
        // Use Queue to order traversal
        // Use Visited List to track word already visited

        Queue<String> queue = new LinkedList<>();
        List<String> visited = new ArrayList<>();

        queue.add(beginWord);
        visited.add(beginWord);

        int step = 1;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int j = 0; j < size; j++) { // required to get minimum steps ladder
                String checkWord = queue.poll();
                System.out.println(checkWord);
                StringBuilder pattern = null;
                for (int i = 0; i < checkWord.length(); i++) {
                    pattern = new StringBuilder(checkWord);
                    pattern.setCharAt(i, '*');

                    for (String possibleWord : patterWordMap.get(pattern.toString())) {
                        if (possibleWord.equals(endWord)) {
                            return step;
                        }

                        if (visited.contains(possibleWord)) {
                            continue;
                        }

                        queue.add(possibleWord);
                        visited.add(possibleWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] wordArray = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
        System.out.println(ladderLength("hit", "cog", wordList));
    }
}
