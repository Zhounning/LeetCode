package leetCode;

/***
 * 字段树
 * 
 * @author zhouning
 * @since 2020-07-30
 */
public class Trie {

    private TrieNode root;

    /** 初始化 */
    public Trie() {
        root = new TrieNode();
    }

    /** 插入 */
    public void insert(String word) {
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

    /**
     * 从字典树中删除 word
     * 
     * @param word
     */
    public void deleteWord(String word) {
        if (!search(word)) {
            return;
        }

        delete(root, word, 0);
    }

    private void delete(TrieNode node, String word, int d) {
        if (d == word.length()) {
            // 说明到了单词的末尾
            node.isEnd = false;
        } else {
            // 说明没有到单词末尾
            char ch = word.charAt(d);
            delete(node.get(ch), word, d + 1);
        }

        /** 如果该节点是一个单词的末尾,则需要保留，不能删除 */
        if (node.isEnd) {
            return;
        }

        for (TrieNode trieNode : node.links) {
            /*** 当前结点的子结点都为空,才能删除 */
            if (trieNode != null) {
                return;
            }
        }

        node = null;

    }

    /***
     * 搜索单词的位置
     * 
     * @param word
     * @return
     */
    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    /****
     * 查找 Trie 中是否存在单词 word
     * 
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /***
     * 判断 Trie 中是或有以 prefix 为前缀的单词
     * 
     * @param prefix
     * @return
     */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    /***
     * 定义树节点
     */
    class TrieNode {

        // 子节点，不同的字典树子节点可能不同
        // 也可以设计出 Map<Character,TrieNode>links ，思想类似
        private TrieNode[] links;

        private final int R = 26;

        // 是最后的子节点标志，是一个单词结束的标志
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
}