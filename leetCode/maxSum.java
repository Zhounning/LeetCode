package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class maxSum {
    public int MaxSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        // 找出相同的数
        for (int i = 0; i < n; i++) {
            map1.put(nums1[i], i);
        }

        for (int i = 0; i < m; i++) {
            if (map1.containsKey(nums2[i])) {
                map2.put(nums2[i], i);
                list.add(nums2[i]);
            }
        }

        list.add(-1);
        int i = 0;
        int j = 0;
        long res = 0;
        while (!list.isEmpty()) {
            int num = list.poll();
            long sum1 = 0;
            long sum2 = 0;
            // -1 说明是最后一位
            int l1 = num == -1 ? n : map1.get(num);
            int l2 = num == -1 ? m : map2.get(num);

            for (; i < l1; i++) {
                sum1 += nums1[i];
            }

            for (; j < l2; j++) {
                sum2 += nums2[j];
            }
            res += Math.max(sum1, sum2);
        }
        long mod = 1000000007;
        return (int) (res % mod);
    }

    public static void main(String[] args) {
        maxSum m = new maxSum();
        int[] nums1 = { 1, 4, 5, 8, 9, 11, 19 };
        int[] nums2 = { 2, 3, 4, 11, 12 };
        System.out.println(m.MaxSum(nums1, nums2));
    }
}