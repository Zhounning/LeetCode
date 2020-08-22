package leetCode;

public class minOperations2 {
    public int minOperations(int[] nums) {
        int ans = 0;
        boolean flag = true;
        while (flag) {
            flag = !flag;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 != 0) {
                    ans++;
                    nums[i]--;
                }
                nums[i] = nums[i] / 2;
                if (nums[i] != 0) {
                    flag = true;
                }
            }
            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        minOperations2 m = new minOperations2();
        int[] nums = { 2, 4, 8, 16 };
        System.out.println(m.minOperations(nums));
    }
}