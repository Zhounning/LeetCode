package leetCode;

public class getMaxLen {
    public int GetMaxLen(int[] nums) {
        int n = nums.length;
        // 其中dp[i][0]代表正数，dp[i][1]代表负数
        int[][] dp = new int[n][2];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
            } else if (nums[i] > 0) {
                // 说明为正数
                if (i > 0) {
                    dp[i][0] = dp[i - 1][0] + 1;
                    if (dp[i - 1][1] > 0) {
                        dp[i][1] = dp[i - 1][1] + 1;
                    }
                } else {
                    dp[i][0] = 1;
                }

            } else {
                // 说明为负数
                if (i > 0) {
                    // 负数由正数得来
                    dp[i][1] = dp[i - 1][0] + 1;

                    if (dp[i - 1][1] > 0) {
                        dp[i][0] = dp[i - 1][1] + 1;
                    }

                } else {
                    dp[i][1] = 1;
                }
            }
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        getMaxLen g = new getMaxLen();
        int[] nums = { 1,2,3,5,-6,4,0,10};
        System.out.println(g.GetMaxLen(nums));
    }
}