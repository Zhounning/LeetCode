package leetCode;

import java.util.ArrayList;
import java.util.List;

public class findWords {

    List<String> res = new ArrayList<>();
    Trie rTrie = new Trie();

    public List<String> FindWords(char[][] board, String[] words) {

        for (String word : words) {
            rTrie.insert(word);
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] visit = new boolean[n][m];
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, visit, i, j, s);
            }
        }

        return res;
    }

    private void dfs(char[][] board, boolean[][] visit, int i, int j, StringBuilder s) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j]) {
            return;
        }
        s.append(board[i][j]);
        visit[i][j] = true;
        if (rTrie.search(s.toString())) {
            res.add(s.toString());
            rTrie.deleteWord(s.toString());
        }

        if (!rTrie.startsWith(s.toString())) {
            s.deleteCharAt(s.length() - 1);
            visit[i][j] = false;
            return;
        }

        dfs(board, visit, i - 1, j, s);
        dfs(board, visit, i + 1, j, s);
        dfs(board, visit, i, j - 1, s);
        dfs(board, visit, i, j + 1, s);
        s.deleteCharAt(s.length() - 1);
        visit[i][j] = false;
    }

    public static void main(String[] args) {
        findWords f = new findWords();
        // char[][] board = new char[][] { new char[] { 'o', 'a', 'a', 'n' }, new char[]
        // { 'e', 't', 'a', 'e' },
        // new char[] { 'i', 'h', 'k', 'r' }, new char[] { 'i', 'f', 'l', 'v' } };
        char[][] board = new char[][] { new char[] { 'a' }, new char[] { 'a' }, };
        String[] words = { "a"};
        System.out.println(f.FindWords(board, words));
    }
}