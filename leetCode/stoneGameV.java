package leetCode;

public class stoneGameV {
    public int StoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[][] dp = new int[n + 1][n + 1];
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }

        // for (int i = 1; i < n + 1; i++) {
        // dp[i][i] = stoneValue[i - 1];
        // }

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i + len <= n + 1; i++) {// 枚举起点，ends<=n
                int j = i + len - 1;
                for (int k = i; k < j; k++) {// 枚举分割点，更新小区间最优解
                    if (sum[k] - sum[i - 1] < sum[j] - sum[k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][k] + sum[k] - sum[i - 1]);

                    } else if (sum[k] - sum[i - 1] > sum[j] - sum[k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k + 1][j] + sum[j] - sum[k]);

                    } else {
                        dp[i][j] = Math.max(dp[i][k], dp[k + 1][j]) + sum[k] - sum[i - 1];
                    }
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        stoneGameV s = new stoneGameV();
        int[] stoneValue = { 6, 2, 3, 4, 5, 5 };
        System.out.println(s.StoneGameV(stoneValue));
    }
}