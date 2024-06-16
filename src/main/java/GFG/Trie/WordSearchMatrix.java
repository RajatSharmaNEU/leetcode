package GFG.Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchMatrix {
    static int ALPHABET_SIZE = 26;

    static class TrieNode {
        Practice.TrieNode[] children = new Practice.TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
    }

    static Practice.TrieNode root = new Practice.TrieNode();

    static void insert(String key) {
        Practice.TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new Practice.TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key) {
        Practice.TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (pCrawl.children[index] == null) {
                return false;
            }

            pCrawl = pCrawl.children[index];
        }

        return pCrawl.isEndOfWord;
    }

    static boolean isEmpty(Practice.TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    // Recursive function to delete a key from given Trie
    static private Practice.TrieNode remove(Practice.TrieNode root, String key, int depth) {
        // If tree is empty
        if (root == null)
            return null;

        // If last character of key is being processed
        if (depth == key.length()) {

            // This node is no more end of word after
            // removal of given key
            if (root.isEndOfWord)
                root.isEndOfWord = false;

            // If given is not prefix of any other word
            if (isEmpty(root)) {
                root = null;
            }

            return root;
        }

        // If not last character, recurring for the child
        // obtained using ASCII value
        int index = key.charAt(depth) - 'a';
        root.children[index] = remove(root.children[index], key, depth + 1);

        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }

        return root;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visit = new boolean[rows][cols];


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(r, c, root, "", result, visit, board, root);
            }
        }

        return result;
    }

    static void dfs(int r, int c, Practice.TrieNode node, String word, List<String> result, boolean[][] visit, char[][] board, Practice.TrieNode root) {
        if(r < 0 || c < 0 || r == board.length || c == board[0].length || visit[r][c] || node.children[board[r][c] - 'a'] == null) {
            return;
        }

        visit[r][c] = true;
        node = node.children[board[r][c] - 'a'];
        word = word + board[r][c];

        if(node.isEndOfWord) {
            node.isEndOfWord = false;
            result.add(word);
            remove(root, word, 0);
        }

        dfs(r + 1, c, node, word, result, visit, board, root);
        dfs(r - 1, c, node, word, result, visit, board, root);
        dfs(r, c + 1, node, word, result, visit, board, root);
        dfs(r, c - 1, node, word, result, visit, board, root);

        visit[r][c] = false;
    }

    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'a', 'b', 'c'},
//                {'a', 'e', 'd'},
//                {'a', 'f', 'g'}
//        };
//
//        String[] words = new String[]{
//                "abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"
//        };

//        char[][] board = new char[][]{
//                {'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'},
//                {'i', 'h', 'k', 'r'},
//                {'i', 'f', 'l', 'v'}
//        };
//
//        String[] words = new String[]{
//                "oath", "pea", "eat", "rain"
//        };

//        char[][] board = new char[][]{
//                {'a'},
//                {'a'}
//        };
//
//        String[] words = new String[]{
//                "aaa"
//        };
//
        char[][] board = new char[][]{
                {'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}
        };

        String[] words = new String[]{
                "oa", "oaa"
        };

        List<String> result = findWords(board, words);
        for (String res : result) {
            System.out.println(res);
        }
    }
}
