package leetCode;

import java.util.Arrays;

public class maxProfit4 {
    // 这种方法，内存超标，因为未考虑到 k>n/2时，最大值是不变的情况
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

    //标准答案
    public int maxProfit2(int k, int[] prices) {
        if (k >= prices.length >>> 1) {
            //相当于k为无限的情况
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        
            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }
            
            return T_ik0;
        }
            
        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);
            
        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }
            
        return T_ik0[k];
    }
    
    public static void main(String[] args) {
        maxProfit4 m = new maxProfit4();
        int k = 2;
        int[] prices = { 2, 4, 1 };
        System.out.println(m.maxProfit(k, prices));
    }
}