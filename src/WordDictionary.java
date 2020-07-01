import java.util.Map;

/**
 * 211. Add and Search Word - Data structure design
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * June 30th
 */
public class WordDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        private final int N = 26;
        TrieNode() {
            children = new TrieNode[N];
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        root.isWord = true;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }

    private boolean dfsSearch(TrieNode cur, String word, int i) {
        if (cur == null) return false;
        if (i == word.length()) return cur.isWord;
        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (dfsSearch(cur.children[j], word, i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            return dfsSearch(cur.children[c - 'a'], word, i + 1);
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
    }
}
