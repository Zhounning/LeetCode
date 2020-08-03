package leetCode;

/**
 * maxSlidingWindow
 */
public class maxSlidingWindow {

    public int[] MaxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            res[i] = max;
        }
        return res;
    }
}