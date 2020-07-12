package leetCode;
/**
 * CanJump
 * 2020-07-12 重做
 */
public class canJump {
   
    public boolean CanJump(int[] nums) {
        if(nums==null)
            return false;

        //可以跳跃的最大长度
        int maxLength = nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            if(maxLength>=i)
                maxLength = Math.max(maxLength, i+nums[i]);
            else
                return false;
        }

        return maxLength>=nums.length-1 ? true:false;
    }
}