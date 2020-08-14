package leetCode;

import java.util.Arrays;

public class mergeStones {
    public int MergeStones(int[] stones, int K) {
        int n = stones.length;
        int[] sum = new int[n + 1];
        int[][] dp = new int[n + 1][n + 1];
        sum[0] = 0;

        Arrays.fill(dp[0], Integer.MAX_VALUE);
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            sum[i] += sum[i - 1] + stones[i - 1];
            dp[i][i] = stones[i - 1];
        }
        // 从2块石头合并开始
        for (int step = 2; step <= n; step++) {
            for (int i = 1; i + step - 1 <= n; i++) {
                int j = i + step - 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] stones = { 3, 2, 4, 1 };
        mergeStones m = new mergeStones();
        int k = 100;
        System.out.println(m.MergeStones(stones, k));
    }
}