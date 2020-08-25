package leetCode;

import java.util.HashMap;
import java.util.Map;

public class findShortestSubArray {
    public int FindShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!left.containsKey(x)) {
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
            degree = Math.max(degree, count.get(x));
        }

        int ans = nums.length;
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
}