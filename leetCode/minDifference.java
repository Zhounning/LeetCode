package leetCode;

import java.util.Arrays;

public class minDifference {
    public int MinDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        if (n > 3) {
            res = Integer.MAX_VALUE;
            // 头部去掉几个元素
            for (int i = 0; i < 4; i++) {
                res = Math.min(res, nums[n - (3 - i) - 1] - nums[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        minDifference m = new minDifference();
        int[] nums = { 82, 81, 95, 75, 20 };
        System.out.println(m.MinDifference(nums));
    }
}