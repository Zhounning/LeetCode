package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class avoidFlood {
    public int[] AvoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        Map<Integer, Integer> water = new HashMap<>();
        List<Integer> zero = new ArrayList<>();

        for (int i = 0; i < rains.length; i++) {
            int r = rains[i];
            // 不下雨
            if (r == 0) {
                zero.add(i);
                continue;
            }
            // 下雨
            if (water.containsKey(r)) {
                int target = water.get(r);
                int left = 0, right = zero.size() - 1;
                // 二分查找日期进行填写
                // 找到前面r下雨后的不下雨天进行填写
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (zero.get(mid) < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                if (left < 0 || left >= zero.size()) {
                    return new int[] {};
                }
                ans[zero.get(left)] = r;
                zero.remove(left);
            }
            water.put(r, i);
            ans[i] = -1;

        }
        return ans;
    }

    public static void main(String[] args) {
        avoidFlood a = new avoidFlood();
        int[] rains = { 69, 0, 0, 0, 69 };
        System.out.println(Arrays.toString(a.AvoidFlood(rains)));
    }
}