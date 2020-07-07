package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * firstMissingPositive
 */
public class firstMissingPositive {
    public int FirstMissingPositive(int[] nums) {
        if (nums==null||nums.length==0) {
            return 1;
        }
     
        Set<Integer> intSet = new HashSet<>();
        for (Integer integer : nums) {
            if (integer>0) {
                intSet.add(integer);
            }
        }
        int res = nums.length;
        for (int i = 1; i <=nums.length+1; i++) {
            if (!intSet.contains(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        firstMissingPositive f =new firstMissingPositive();
        int[] nums = {};
        System.out.println(f.FirstMissingPositive(nums));
    }
}