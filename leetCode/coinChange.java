package leetCode;

import java.util.Arrays;

public class coinChange {
    public int CoinChange(int[] coins, int amount) {

        // dp[i] 表示amount为i时,可以凑成总金额所需的最少的硬币个数。
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    //采用背包思想
    public int CoinChange2(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        coinChange c = new coinChange();
        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(c.CoinChange(coins, amount));
    }
}
