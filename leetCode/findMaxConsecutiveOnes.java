package leetCode;

public class findMaxConsecutiveOnes {
    public int FindMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0;
            } else {
                count++;
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        findMaxConsecutiveOnes f = new findMaxConsecutiveOnes();
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println(f.FindMaxConsecutiveOnes(nums));
    }
}