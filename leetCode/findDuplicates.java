package leetCode;

import java.util.ArrayList;
import java.util.List;

public class findDuplicates {
    public List<Integer> FindDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int newIndex = (nums[i] - 1) % n;
            nums[newIndex] += n;

        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 2 * n) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        findDuplicates f = new findDuplicates();
        int[] nums = { 4,3,2,7,8,2,3,1 };
        System.out.println(f.FindDuplicates(nums));
    }
}