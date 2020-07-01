package lintcode;

import java.util.HashMap;
import java.util.Map;

public class backPackIV {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int BackPackIV(int[] nums, int target) {
        // write your code here
        if(nums==null||nums.length<=0||target<=0){
            return 0;
        }

        int []dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j<dp.length; j++) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        backPackIV b = new backPackIV();
        int m=11;
        int[]A = {8,7,4,3};
        System.out.println(b.BackPackIV(A, m));
    }

}