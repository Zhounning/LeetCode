package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class numSubseq {
    public int NumSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();

        int l = 0, count = 0;
        long result = 0;
        for (int r = 0; r < nums.length; ++r) {
        }
        return (int) result;
    }

    public static void main(String[] args) {
        numSubseq n = new numSubseq();
        int[] nums = { 3, 5, 6, 7 };
        int target = 9;
        System.out.println(n.NumSubseq(nums, target));
    }
}