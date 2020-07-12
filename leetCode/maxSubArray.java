package leetCode;
/**
 * MaxSubArray
 * 2020-07-12 重做
 */
public class maxSubArray {
    
    public int MaxSubArray(int[] nums) {
        if(nums==null) return 0;
        int res = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i],cur+nums[i]);
            res = Math.max(res,cur);
        }
        return res;
    }

    public static void main(String[] args) {
        maxSubArray m =new maxSubArray();
        int []nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.MaxSubArray(nums));
    }
    
}