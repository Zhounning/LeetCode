package leetCode.offer;

public class majorityElement {

    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ans) {
                num++;
            } else {
                num--;
            }

            if (num == 0) {
                ans = nums[i];
                num = 1;
            }
        }
        return ans;
    }
}