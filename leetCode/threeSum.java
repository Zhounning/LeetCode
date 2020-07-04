package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSum
 * 2020-07-04重做
 */
public class threeSum {
    // 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

    // 注意：答案中不可以包含重复的三元组。
    
    //  
    
    // 示例：
    
    // 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    
    // 满足要求的三元组集合为：
    // [
    //   [-1, 0, 1],
    //   [-1, -1, 2]
    // ]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/3sum
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public List<List<Integer>> ThreeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);//利用排序解决重复问题
        int p1 =0;
        int p2 =nums.length-1;
        int target = 0; //target可以为任意数
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            p1=i+1;p2 = nums.length-1;
            //转化为两数之和
            while (p1<p2) {
                int sum = nums[i]+nums[p1]+nums[p2];
                 if(sum==target){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
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
        return res;
    }

   

    public static void main(String[] args) {
        threeSum t = new threeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(t.ThreeSum(nums));
    }

}