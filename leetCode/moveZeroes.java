package leetCode;

import java.util.Arrays;

public class moveZeroes {
    public void MoveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                last++;
                nums[last] = nums[i];
            }
        }

        for (int i = last+1; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        moveZeroes m = new moveZeroes();
        int[] nums = { 0, 1, 0, 3, 12 };
        m.MoveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}