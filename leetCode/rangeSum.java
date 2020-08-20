package leetCode;

import java.util.PriorityQueue;

public class rangeSum {
    public int RangeSum(int[] nums, int n, int left, int right) {
        int MOD = 1_000_000_007;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] { nums[i], i });
        }
        long ans = 0;
        int count = 0;
        while (count < right && !heap.isEmpty()) {
            int[] cp = heap.poll();
            count++;
            if (count >= left) {
                ans += cp[0] % MOD;
                ans = ans % MOD;
            }

            if (cp[1] < n - 1) {
                // 说明在范围内,表示从cp[1]向后再加1个数的连续和
                heap.offer(new int[] { (cp[0] + nums[cp[1] + 1]), cp[1] + 1 });
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        rangeSum r = new rangeSum();
        int[] nums = { 1, 2, 3, 4 };
        int n = 4;
        int left = 1;
        int right = 5;
        System.out.println(r.RangeSum(nums, n, left, right));
    }
}