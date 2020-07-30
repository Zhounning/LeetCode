package leetCode;

public class minSubArrayLen {
    public int MinSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        // 滑动窗口
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        minSubArrayLen m = new minSubArrayLen();
        int s = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(m.MinSubArrayLen(s, nums));
    }
}