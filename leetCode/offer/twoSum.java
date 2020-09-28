package leetCode.offer;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            if (nums[p1] + nums[p2] == target) {
                return new int[] { nums[p1], nums[p2] };
            } else if (nums[p1] + nums[p2] < target) {
                p1++;
            } else {
                p2++;
            }
        }
        return null;
    }
}