package leetCode.offer;

public class movingCount {
    public int MovingCount(int m, int n, int k) {
        boolean[][] isvisit = new boolean[m][n];
        return dfs(0, 0, m, n, k, isvisit);
    }

    int dfs(int i, int j, int m, int n, int k, boolean[][] isvisit) {

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (isvisit[i][j] || !check(i, j, k)) {
            return 0;
        }
        int cnt = 1;
        isvisit[i][j] = true;
        cnt += dfs(i + 1, j, m, n, k, isvisit);
        cnt += dfs(i - 1, j, m, n, k, isvisit);
        cnt += dfs(i, j + 1, m, n, k, isvisit);
        cnt += dfs(i, j - 1, m, n, k, isvisit);
        return cnt;
    }

    boolean check(int i, int j, int k) {
        int num = 0;
        num += i / 10 + i % 10;
        num += j / 10 + j % 10;
        return num <= k;
    }
}