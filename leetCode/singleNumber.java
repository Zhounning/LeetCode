package leetCode;

public class singleNumber {
    public int SingleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        singleNumber s = new singleNumber();
        int []nums = {2,2,1};
        System.out.println(s.SingleNumber(nums));
    }
}