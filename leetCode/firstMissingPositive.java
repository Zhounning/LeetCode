package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * firstMissingPositive
 */
public class firstMissingPositive {
    public int FirstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        Set<Integer> intSet = new HashSet<>();
        for (Integer integer : nums) {
            if (integer > 0) {
                intSet.add(integer);
            }
        }
        int res = nums.length;
        for (int i = 1; i <= nums.length + 1; i++) {
            if (!intSet.contains(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

    public int FirstMissingPositive2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        firstMissingPositive f = new firstMissingPositive();
        int[] nums = { 3, 4, -1, 1 };
        System.out.println(f.FirstMissingPositive2(nums));
    }
}