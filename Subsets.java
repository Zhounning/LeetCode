import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 */
public class Subsets {
    // 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

    // 说明：解集不能包含重复的子集。
    
    // 示例:
    
    // 输入: nums = [1,2,3]
    // 输出:
    // [
    //   [3],
    //   [1],
    //   [2],
    //   [1,2,3],
    //   [1,3],
    //   [2,3],
    //   [1,2],
    //   []
    // ]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/subsets
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    List<List<Integer>> res = new ArrayList<>();
    int k = 0;
    public List<List<Integer>> subsets(int[] nums) {
        
        //dfs1的部分
        // ArrayList<Integer>ans = new ArrayList<>();
        // dfs(nums,ans,0);
        // return res;res

        //dfs2部分
      
        for (k = 0; k < nums.length + 1; ++k) {
          dfs2(nums,new ArrayList<>(),0);
        }
        return res;
    
 
    }

    /**
     * 回溯
     * @param nums
     * @param ans
     * @param n 从第n个数开始没有被访问
     */
    public void dfs(int []nums,ArrayList<Integer>ans,int n){
        res.add(new ArrayList(ans));
        for (int i = n; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(nums, ans, i+1);
           ans.remove(ans.size()-1);
        }
        
    }


    public void dfs2(int []nums,ArrayList<Integer>ans,int n){
        
        if(ans.size()==k)
            res.add(new ArrayList(ans));

        for (int i = n; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(nums, ans, i+1);
            ans.remove(ans.size()-1);
        }
    }



    public static void main(String[] args) {
        int [] nums =new int[] {1,2,3};
        Subsets subsets = new Subsets();
        subsets.subsets(nums);
    }
}