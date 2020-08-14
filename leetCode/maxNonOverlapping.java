package leetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class maxNonOverlapping {

    public int MaxNonOverlapping(int[] nums, int target) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - target)) {
                count++;
                // 从新还是求前缀和
                sum = 0;
                map = new HashMap<>();
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        maxNonOverlapping m = new maxNonOverlapping();
        int[] nums = { -1, 3, 5, 1, 4, 2, -9 };
        int target = 6;
        System.out.println(m.MaxNonOverlapping(nums, target));
    }
}