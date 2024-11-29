package GFG.Trie;

class WordDictionary {
    int alphabets = 26;
    WordDictionary[] children;
    boolean isEndOfWord;

    public WordDictionary() {
        this.children = new WordDictionary[alphabets];
        this.isEndOfWord = false;
    }

    public void addWord(String word) {
        WordDictionary pCrawl = this;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new WordDictionary();
            }
            pCrawl = pCrawl.children[index];
        }

        pCrawl.isEndOfWord = true;
    }

    public boolean search(String word) {
        WordDictionary pCrawl = this;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (word.charAt(i) == '.') {
                for(WordDictionary wd: pCrawl.children) {
                    if(wd != null && wd.search(word.substring(i+1))) {
                        return true;
                    }
                }
                return false;
            } else {
                if (pCrawl.children[index] == null) {
                    return false;
                }
                pCrawl = pCrawl.children[index];
            }
        }

        return pCrawl.isEndOfWord;
    }

    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.search("."));
        System.out.println(wd.search("a"));
        System.out.println(wd.search("aa"));
        System.out.println(wd.search("a"));
        System.out.println(wd.search(".a"));
        System.out.println(wd.search("a."));
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
