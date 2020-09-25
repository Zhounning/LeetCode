package leetCode.offer;

/**
 * maxSubArray
 */
public class maxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int dp[] = new int[n];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = nums[i];
            if (i > 0) {
                dp[i] = Math.max(dp[i], nums[i] + dp[i - 1]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}