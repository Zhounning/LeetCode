package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SubsetsWithDup
 */
public class SubsetsWithDup {
    // 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

    // 说明：解集不能包含重复的子集。
    
    // 示例:
    
    // 输入: [1,2,2]
    // 输出:
    // [
    //   [2],
    //   [1],
    //   [1,2,2],
    //   [2,2],
    //   [1,2],
    //   []
    // ]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/subsets-ii
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    List<List<Integer>> res = new ArrayList<>();
    // boolean[] visited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer>ans = new ArrayList<>();
        dfs2(nums,ans,0);
        return res;
    }

    //以前写的
    public void dfs(int []nums,List<Integer>ans,int n){
        res.add(new ArrayList(ans));
        for (int i = n; i < nums.length; i++) {
             //剪枝情况
             //这个判断需要理解
            if (i > n && nums[i] == nums[i - 1] ) continue;
            ans.add(nums[i]);
            dfs(nums, ans, i+1);
           ans.remove(ans.size()-1);
        }
        
    }

    //总结的时候写的
    public void dfs2(int []nums,List<Integer>ans,int n){
        res.add(new ArrayList(ans));
        Set<Integer> intSet = new HashSet<Integer>();
        for (int i = n; i < nums.length; i++) {
             //剪枝情况
             //这个判断需要理解
            if (!intSet.contains(nums[i])){
                intSet.add(nums[i]);
                ans.add(nums[i]);
                dfs2(nums, ans, i+1);
               ans.remove(ans.size()-1);
            }
           
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        int[] nums = new int[]{4,4,4,1,4};
        System.out.println(s.subsetsWithDup(nums));
    }



}