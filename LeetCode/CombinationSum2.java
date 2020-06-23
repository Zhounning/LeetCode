import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CombinationSum2
 */
public class CombinationSum2 {
    // 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

    // candidates 中的每个数字在每个组合中只能使用一次。
    
    // 说明：
    
    // 所有数字（包括目标数）都是正整数。
    // 解集不能包含重复的组合。 
    // 示例 1:
    
    // 输入: candidates = [10,1,2,7,6,1,5], target = 8,
    // 所求解集为:
    // [
    //   [1, 7],
    //   [1, 2, 5],
    //   [2, 6],
    //   [1, 1, 6]
    // ]
    // 示例 2:
    
    // 输入: candidates = [2,5,2,1,2], target = 5,
    // 所求解集为:
    // [
    //   [1,2,2],
    //   [5]
    // ]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/combination-sum-ii
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    List<List<Integer>> res=new ArrayList<>();   //最终的答案
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, ans, 0, target);
        return res;
    }

     //加强版，如果先排序，然后前面的都通过不了，后面的就不需要看了.，能够减少不少时间
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

            if((sum+candidates[i])>target)
                break;
            
            ans.add(candidates[i]);
            backtrack(candidates, ans, i, target);
            ans.remove(ans.size()-1);
        }
    }
}