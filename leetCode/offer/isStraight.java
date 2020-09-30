package leetCode.offer;

import java.util.Arrays;

public class isStraight {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        while (count < nums.length && nums[count] == 0) {
            count++;
        }

        for (int i = count + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            if (nums[i] != nums[i - 1] + 1) {
                count -= nums[i] - nums[i - 1] - 1;
            }

            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}