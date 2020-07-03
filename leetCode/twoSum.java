package leetCode;
/**
 * twoSum
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 2020-07-02 重新写
 */
public class twoSum {
    
    //暴力法
    public int[] TwoSum(int[] nums, int target) {
        if (nums==null || nums.length<=1) {
            return null;
        }
        int []ans = new int[2];
       for (int i = 0; i < nums.length; i++) {
           for (int j = i+1; j < nums.length; j++) {
               if (nums[i]+nums[j]==target) {
                    ans[0]=i;
                    ans[1]=j;
                   break;
               }
           }
       }
       if (ans[0]!=ans[1]) {
           return ans;
       }
       return null;
   }

   //如果当中有元素重复就无法解决
    public int[] TwoSum2(int[] nums, int target) {
        if (nums==null || nums.length<=1) {
            return null;
        }
        int []ans = new int[2];
        Map<Integer,Integer> helperMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (helperMap.containsKey(target-nums[i]) && helperMap.get(target-nums[i])!=i) {
                ans[0] = helperMap.get(target-nums[i]);
                ans[1] = i;
                break;
            }
            helperMap.put(nums[i],i);
        }

      
        if (ans[0]!=ans[1]) {
            return ans;
        }
        return null;
    }


    public static void main(String[] args) {
        int []nums = {3,2,4};
        int target = 6;
        twoSum t = new twoSum();
        int []res = t.TwoSum2(nums,target);
        System.out.println(Arrays.toString(res));
    }
}