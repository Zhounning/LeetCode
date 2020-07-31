package leetCode;

import java.util.HashSet;
import java.util.Set;

public class containsNearbyDuplicate {
    public boolean ContainsNearbyDuplicate(int[] nums, int k) {
        // 用散列表来维护这个kk大小的滑动窗口。
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
}