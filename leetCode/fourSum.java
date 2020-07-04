package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  2020-07-04 
 */
public class fourSum {
    public List<List<Integer>> FourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);//利用排序解决重复问题
        int p1 =0;
        int p2 =nums.length-1;
        //和三数之后思路相同
        for (int i = 0; i < nums.length-3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;   //确保第一个数发生变化
           for (int j = i+1; j < nums.length-2; j++) {
               if(j>i+1 && nums[j] == nums[j - 1]) continue; //确保第二个数发生变化
               p1=j+1;p2 = nums.length-1;
               //转化为两数之和
               while (p1<p2) {
                    int sum = nums[i]+nums[j]+nums[p1]+nums[p2];
                    if(sum==target){
                       List<Integer> ans = new ArrayList<>();
                       ans.add(nums[i]);
                       ans.add(nums[j]);
                       ans.add(nums[p1]);
                       ans.add(nums[p2]);
                       res.add(ans);
                       //解决重复问题
                       while(p1<p2&&nums[p1]==nums[p1+1]){
                           p1++;
                       }
                       p1++;
                       while (p1<p2&&nums[p2]==nums[p2-1]) {
                           p2--;
                       }
                       p2--;
                   }else if(sum<target){
                       p1++;
                   }else if(sum>target){
                       p2--;
                   }
               }
           }
        }
        return res;
    }
    public static void main(String[] args) {
        fourSum f =new fourSum();
        int[] nums={1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(f.FourSum(nums,target));
    }
}