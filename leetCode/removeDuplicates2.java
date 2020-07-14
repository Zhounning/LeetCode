package leetCode;

/**
 * 做多出现两次两次
 */
public class removeDuplicates2 {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int length = 1; //最终数组的长度
        int lastposition = 0;   //上次的位置
        int allowLength = 1;    //容忍的长度
        for (int i = 1; i < nums.length; i++) {
            if (nums[lastposition]==nums[i]) {
                //当出现重复数字的时候
                if (allowLength<=1) {
                    allowLength++;
                    nums[++lastposition]=nums[i];
                    length++;
                }
                
            }else{
                //说明不相同
                nums[++lastposition] = nums[i];
                length++;
                allowLength = 1;
            }
        }
        return length;
        
    }
}