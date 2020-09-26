package leetCode.offer;

public class maxValue {
    public int MaxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        // for (int i = 0; i < n; i++) {
        //     dp[i] = i > 0 ? dp[i - 1] + grid[0][i] : grid[0][i];
        // }

        for (int i = 0; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        maxValue m = new maxValue();
        int [][]grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(m.MaxValue(grid));
    }
}