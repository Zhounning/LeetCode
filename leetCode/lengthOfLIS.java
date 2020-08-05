package leetCode;

import java.util.Arrays;

public class lengthOfLIS {
    public int LengthOfLIS(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}