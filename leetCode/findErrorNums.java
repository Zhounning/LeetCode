package leetCode;

import java.util.Arrays;

public class findErrorNums {

    public int[] FindErrorNums(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n + 1];

        for (int i : nums) {
            hash[i]++;
        }
        int[] res = new int[2];
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 2) {
                res[0] = i;
            }

            if (hash[i] == 0) {
                res[1] = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findErrorNums f = new findErrorNums();
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(f.FindErrorNums(nums)));
    }
}