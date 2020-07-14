package leetCode;
/**
 * RemoveDuplicates
 * 2020-07-14
 */
public class removeDuplicates {

    //每个出现一次
    //说白了统计不相同字的个数,直接使用双指针
    public int RemoveDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int last = 0;   //记录上个数字的位置
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(temp!=nums[i]){
                nums[last+1] = nums[i];
                last++;
                temp =nums[i];
            }

        }
        return last+1;
    }

    //每个出现两次
    public int removeDuplicates2(int[] nums) {
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