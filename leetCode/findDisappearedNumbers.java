package leetCode;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumbers {
    public List<Integer> FindDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newIndex = Math.abs(nums[i]) - 1;
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}