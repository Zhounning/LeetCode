package leetCode;

public class numIslands {
    public int NumIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从陆地开始搜索
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || grid[i][j] == '#') {
            // grid[i][j] == '#' 说明已经搜索过了.
            return;
        }
        grid[i][j] = '#';
        dfs(grid, i - 1, j); // 上
        dfs(grid, i + 1, j); // 下
        dfs(grid, i, j - 1); // 左
        dfs(grid, i, j + 1); // 右
    }

    public static void main(String[] args) {
        char[][] grid = { new char[] { '1', '1', '0', '0', '0' }, new char[] { '1', '1', '0', '0', '0' },
                new char[] { '0', '0', '1', '0', '0' }, new char[] { '0', '0', '0', '1', '1' } };
        numIslands n = new numIslands();
        System.out.println(n.NumIslands(grid));
    }
}