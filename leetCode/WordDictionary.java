package leetCode;

public class WordDictionary {

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(TrieNode node, String word, int idx) {
        if (node != null) {
            if (idx == word.length()) {
                return node;
            }
            char ch = word.charAt(idx);
            if (ch == '.') {
                for (TrieNode trieNode : node.links) {
                    TrieNode res = searchPrefix(trieNode, word, idx + 1);
                    if (res != null && res.isEnd) {
                        return res;
                    }
                }

            } else {
                return searchPrefix(node.get(ch), word, idx + 1);
            }
        }
        return null;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(root, word, 0);
        return node != null && node.isEnd();
    }

    class TrieNode {

        // 子节点
        private TrieNode[] links;

        private final int R = 26;
        // 是最后的子节点标志
        private boolean isEnd;

        public TrieNode() {
            // 子树最多26位
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("ran");
        obj.addWord("rune");
        obj.addWord("runs");
        obj.addWord("add");
        obj.addWord("adds");
        obj.addWord("adder");
        System.out.println(obj.search("add."));

    }
}