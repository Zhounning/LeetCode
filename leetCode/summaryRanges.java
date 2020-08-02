package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class summaryRanges {
    public List<String> SummaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        int i = 0;
        int temp = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (temp + 1 == nums[j]) {
                temp++;
            } else {
                String s;
                if (i != j - 1) {
                    s = nums[i] + "->" + nums[j - 1];
                } else {
                    s = String.valueOf(nums[i]);
                }
                res.add(s);
                temp = nums[j];
                i = j;
            }
        }
        String s;
        if (i != nums.length - 1) {
            s = nums[i] + "->" + nums[nums.length - 1];
        } else {
            s = String.valueOf(nums[i]);
        }
        res.add(s);
        return res;
    }

    public static void main(String[] args) {
        summaryRanges s = new summaryRanges();
        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println(s.SummaryRanges(nums));
    }
}