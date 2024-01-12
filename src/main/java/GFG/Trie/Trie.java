package GFG.Trie;

public class Trie {

    private int ALPHABET_SIZE = 26;

    class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
    }

    private TrieNode root = new TrieNode();

    private void insert(String key) {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    private boolean search(String key) {
        TrieNode pCrawl = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';

            if (pCrawl.children[index] == null) {
                return false;
            }

            pCrawl = pCrawl.children[index];
        }

        return pCrawl.isEndOfWord;
    }

    boolean isEmpty(TrieNode root) {
        for (int i = 0; i < ALPHABET_SIZE; i++)
            if (root.children[i] != null)
                return false;
        return true;
    }

    // Recursive function to delete a key from given Trie
    private TrieNode remove(TrieNode root, String key, int depth) {
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

    public static void main(String[] args) {
        Trie trie = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their"};
        String keys2[] = {"bat", "bad", "cat", "cut", "geek", "geeks", "zoo"};

        // Insert
        for (int i = 0; i < keys.length; i++) {
            trie.insert(keys[i]);
        }

        System.out.println(trie.search("the"));
        System.out.println(trie.search("these"));
        System.out.println(trie.search("their"));
        System.out.println(trie.search("thaw"));

        trie.remove(trie.root, "these", 0);

        System.out.println(trie.search("these"));
    }
}
