package leetCode.offer;

public class exchange {
    public int[] Exchange(int[] nums) {
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                // 说明是奇数
                pre++;
                swap(nums, i, pre);
            }
        }
        return nums;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}