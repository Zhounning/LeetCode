package leetCode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * CombinationSum
 */
public class CombinationSum {

    // 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    // candidates 中的数字可以无限制重复被选取。
    
    // 说明：
    
    // 所有数字（包括 target）都是正整数。
    // 解集不能包含重复的组合。 
    // 示例 1:
    
    // 输入: candidates = [2,3,6,7], target = 7,
    // 所求解集为:
    // [
    //   [7],
    //   [2,2,3]
    // ]
    // 示例 2:
    
    // 输入: candidates = [2,3,5], target = 8,
    // 所求解集为:
    // [
    //   [2,2,2,2],
    //   [2,3,3],
    //   [3,5]
    // ]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/combination-sum
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    List<List<Integer>> res=new ArrayList<>();   //最终的答案
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, ans, 0, target);
        return res;
    }


    public void backtrack(int[] candidates,List<Integer>ans,int n,int target){
        
        int sum = 0;
        for (Integer integer : ans) {
            sum+=integer;
        }

        //进行对应的剪枝
        if(sum>target) return ;
        if(sum==target) {
            List<Integer> newList = new ArrayList<>();
            for (Integer integer : ans ) {
                newList.add(integer);
            }
            res.add(newList);
            return ;
        }

        for (int i = n; i <candidates.length; i++) {
            ans.add(candidates[i]);
            backtrack(candidates, ans, i, target);
            ans.remove(ans.size()-1);
        }
    }

    //加强版，如果先排序，然后前面的都通过不了，后面的就不需要看了.，能够减少不少时间
    public void backtrack2(int[] candidates,List<Integer>ans,int n,int target){
        
        int sum = 0;
        for (Integer integer : ans) {
            sum+=integer;
        }

        //进行对应的剪枝
        if(sum>target) return ;
        if(sum==target) {
            List<Integer> newList = new ArrayList<>();
            for (Integer integer : ans ) {
                newList.add(integer);
            }
            res.add(newList);
            return ;
        }

        for (int i = n; i <candidates.length; i++) {
            if(i > n && candidates[i] == candidates[i-1]) continue; //去掉相等的数据
            if((sum+candidates[i])>target)
                break;
            
            ans.add(candidates[i]);
            backtrack(candidates, ans, i, target);
            ans.remove(ans.size()-1);
        }
    }

}