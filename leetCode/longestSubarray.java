package leetCode;

import java.util.ArrayList;

public class longestSubarray {
    public int LongestSubarray(int[] nums) {
        // 记录每段1的数量
        ArrayList<Integer> a = new ArrayList<>();
        // 记录0每段的数量
        ArrayList<Integer> b = new ArrayList<>();
        int count0 = 0;
        int count1 = 0;
        // 加个0进行守护
        if (nums[0] == 1) {
            a.add(0);
        }

        for (Integer integer : nums) {
            if (integer == 0) {
                // 说明0开始计算
                if (count0 == 0) {
                    a.add(count1);
                }
                count1 = 0;
                count0++;
            } else {
                // 说明1开始计算
                if (count1 == 0) {
                    b.add(count0);
                }
                count0 = 0;
                count1++;
            }
        }

        if (count1 != 0) {
            a.add(count1);
        } else if (count0 != 0) {
            b.add(count0);
        }
        // 说明没有1
        if (a.size() == 1) {
            return 0;
        }
        // 说明没有0
        if (b.size() == 1 && b.get(0)==0) {
            return nums.length - 1;
        }

        int max_count1 = 0;
        for (int i = 0; i < a.size() - 1; i++) {
            if (b.get(i) < 2) {
                max_count1 = Math.max(a.get(i) + a.get(i + 1), max_count1);
            } else {
                max_count1 = Math.max(max_count1, a.get(i));
            }
        }
        max_count1 = Math.max(max_count1, a.get(a.size() - 1));
        return max_count1;
    }

    public static void main(String[] args) {
        longestSubarray l = new longestSubarray();
        int[] nums = { 0, 0, 1, 1 };
        System.out.println(l.LongestSubarray(nums));
    }

}