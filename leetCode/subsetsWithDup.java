package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SubsetsWithDup
 */
public class subsetsWithDup {
    List<List<Integer>> res = new LinkedList<>();
    int []nums;
    public List<List<Integer>> SubsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        LinkedList<Integer>ans = new LinkedList<>();
        dfs(ans,0);
        return res;
    }

    //以前写的
    public void dfs(LinkedList<Integer>ans,int n){
        res.add(new LinkedList(ans));
        for (int i = n; i < nums.length; i++) {
             //剪枝情况
             //这个判断需要理解
            if (i > n && nums[i] == nums[i - 1] ) continue;
            ans.add(nums[i]);
            dfs(ans, i+1);
            ans.removeLast();
        }
        
    }

    public static void main(String[] args) {
        subsetsWithDup s = new subsetsWithDup();
        int[] nums = new int[]{4,4,4,1,4};
        System.out.println(s.SubsetsWithDup(nums));
    }



}