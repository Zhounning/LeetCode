package leetCode;

public class rob {
    public int Rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        rob r = new rob();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(r.Rob(nums));
    }
}