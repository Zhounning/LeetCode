package leetCode;

import java.util.HashSet;

/**
 * minMoves
 */
public class minMoves {
    HashMap  
    
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }

        int ans = 0;
        for (int i : nums) {
            ans += (i - min);
        }
        return ans;
    }
}