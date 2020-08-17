package leetCode;

public class splitArray {
    public int SplitArray(int[] nums, int m) {
        int minVal = Integer.MAX_VALUE;
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            minVal = Math.min(minVal, nums[i]);
            sum += nums[i];
        }
        if (m == 1) {
            return (int) sum;
        }

        long left = minVal;
        long right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (check(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    /***
     * 贪心思想
     * 
     * @param nums
     * @param m      数组划分为m个
     * @param target 子数组和最大值的最小化
     * @return
     */
    boolean check(int[] nums, int m, long target) {
        // 区间数量
        int cnt = 0;
        long sum = 0;

        int i = 0;
        while (i < nums.length) {
            if (nums[i] > target) {
                return false;
            }
            while (i < nums.length && sum <= target) {
                sum += nums[i];
                i++;
            }

            if (i == nums.length && sum <= target) {
                cnt++;
                break;
            }
            cnt += 1;
            sum = 0;
            i--;
        }

        return cnt <= m;
    }

    public static void main(String[] args) {
        splitArray s = new splitArray();
        int[] nums = { 1, 2147483647 };
        int m = 2;
        System.out.println(s.SplitArray(nums, m));
    }
}