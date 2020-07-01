package lintcode;

public class backPackV {
     /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int BackPackV(int[] nums, int target) {
        // write your code here
        if(nums==null||nums.length<=0||target<=0){
            return 0;
        }

        int []dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j>=nums[i]; j--) {
                dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        backPackV b = new backPackV();
        int m=7;
        int[]A = {1,2,3,3,7};
        System.out.println(b.BackPackV(A, m));
    }
}