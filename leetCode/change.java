package leetCode;

public class change {

    public int Change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        // 代表次数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            // 正序
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        change c = new change();
        int[] coins = { 3 };
        int amount = 2;
        System.out.println(c.Change(amount, coins));
    }
}