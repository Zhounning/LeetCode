package leetCode;

public class maxProfit4 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // dp[i][k][0] 表示第i天，手上没有股票时的最大值,其中k表示第几次交易
        // dp[i][k][1] 表示第i天，手上买入股票时 的最大值，其中k表示第几次交易
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[i][j][0] = i == 0 ? 0 : Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = i == 0 ? -prices[i] : Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    public static void main(String[] args) {
        maxProfit4 m = new maxProfit4();
        int k = 2;
        int[] prices = { 2, 4, 1 };
        System.out.println(m.maxProfit(k, prices));
    }
}