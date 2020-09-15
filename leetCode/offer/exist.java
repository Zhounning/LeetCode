package leetCode.offer;

public class exist {
    public boolean Exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] isvisited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, isvisited))
                        return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] isvisited) {
        if (idx==word.length()) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }

        if (isvisited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }
        isvisited[i][j] = true;
        if (dfs(board, i - 1, j, word, idx + 1, isvisited)) {
            return true;
        }

        if (dfs(board, i + 1, j, word, idx + 1, isvisited)) {
            return true;
        }
        if (dfs(board, i, j - 1, word, idx + 1, isvisited)) {
            return true;
        }
        if (dfs(board, i, j + 1, word, idx + 1, isvisited)) {
            return true;
        }

        isvisited[i][j] = false;
        return false;
    }
}