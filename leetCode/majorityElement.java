package leetCode;

public class majorityElement {
    public int MajorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
            }

            if (nums[i] != res) {
                count--;
            } else {
                count++;
            }
        }
        return res;
    }
}