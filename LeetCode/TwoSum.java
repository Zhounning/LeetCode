package leetCode;
/**
 * twoSum
 */

import java.util.HashMap;
public class TwoSum {
    /***
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/two-sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        
        //对空指针进行判断
        if(nums==null)
            return null;

        int res[] = new int[2];
        HashMap<Integer,Integer>numMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            numMap.put(nums[i],i);
        }

        for(int i=0;i<nums.length;++i){
            if(numMap.get(target - nums[i])!=null)
            {
                if((int) numMap.get(target - nums[i])!=i){
                    res[0] = i;
                    res[1] = (int) numMap.get(target - nums[i]);
                    break;
                }
                
            }
        }
        
        return res;
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //注意2和1的区别是2是升序的
    public int[] twoSum2(int[] numbers, int target) {
        //对空指针进行判断
        if(numbers==null)
            return null;
        // 使用双指针,类似于二分法的思想
        int p1 = 0;
        int p2 =numbers.length-1;
       // int []res = null;
        while(p1<p2){
            if(numbers[p1]+numbers[p2]==target)
            {
                return new int[]{p1+1,p2+1};
            }

            if (numbers[p1]+numbers[p2]<target) {
                p1++;
            }

            if (numbers[p1]+numbers[p2]>target) {
                p2--;
            }

        }

        return null;
    }

    public static void main(String[] args) {
        int []nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum t = new TwoSum();
        int []res = t.twoSum(nums,target);
        System.out.println(res[1]);
    }
}