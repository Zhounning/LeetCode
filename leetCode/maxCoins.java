package leetCode;

public class maxCoins {
    // 区间dp
    public int MaxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        // 在左右两边加1
        temp[0] = temp[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            temp[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];
        // 扎气球的数量
        for (int step = 1; step <= n; step++) {
            for (int i = 1; i + step - 1 <= n; i++) {
                int j = i + step - 1;
                for (int k = i; k <= j; k++) {
                    // 将第k个气球戳破
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + temp[i - 1] * temp[k] * temp[j + 1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        maxCoins m = new maxCoins();
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(m.MaxCoins(nums));
    }
}