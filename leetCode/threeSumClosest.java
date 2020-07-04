package leetCode;

import java.util.Arrays;

public class threeSumClosest {
    public int ThreeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int p1 =0;
        int p2 =nums.length-1;
        int closetNum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            p1=i+1;p2 = nums.length-1;
            int sum = nums[p1]+nums[p2]+nums[i];
            //转化为两数之和
            while (p1<p2) {
                sum = nums[p1]+nums[p2]+nums[i];
                //改变closetNum
                if(Math.abs(sum-target)<Math.abs(closetNum-target)){
                    closetNum = sum;
                }

                if(sum==target){
                   return target;
                }else if(sum<target){

                   p1++;
                }else if(sum>target){

                   p2--;
                }
           }
        }
        return closetNum;
    }

    public static void main(String[] args) {
        threeSumClosest t = new threeSumClosest();
        int []nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(t.ThreeSumClosest(nums, target));
    }
}