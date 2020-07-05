package leetCode;

import java.util.Arrays;

public class removeElement {
    public int RemoveElement(int[] nums, int val) {
        if (nums==null || nums.length==0) {
            return 0;
        }

        int length = 0;
        int last = -1;   //记录上个数字的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val) {
                nums[last+1] = nums[i];
                length++;
                last++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        removeElement r =new removeElement();
        int []nums = {0,1,2,2,3,0,4,2};
        int val =2;
        
        System.out.println(r.RemoveElement(nums, val));
        System.out.println(Arrays.toString(nums));
    }
}