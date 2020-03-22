
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * PermuteUnique
 */
public class PermuteUnique {
    // 给定一个可包含重复数字的序列，返回所有不重复的全排列。

    // 示例:
    
    // 输入: [1,1,2]
    // 输出:
    // [
    //   [1,1,2],
    //   [1,2,1],
    //   [2,1,1]
    // ]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/permutations-ii
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack2(nums,ans,visited);
        return res;
    }

    //错的答案
    public void backtrack(int [] nums,int n){
        
        if(n==nums.length) {
            List<Integer> newList = new ArrayList<>();
            for (Integer integer : nums ) {
                newList.add(integer);
            }
           res.add(newList);
        }

        for (int i = n; i < nums.length; i++) {

            if (i>n&&nums[i]==nums[i-1]) {
                continue;
            }
            //进行交换
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;
           
            backtrack(nums,  n+1);

            nums[n] = nums[i];
            nums[i] = temp;
        }
       
    }

    //正确的答案
    public void backtrack2(int []nums,List<Integer> ans,boolean[] visited){
        
        if(ans.size()==nums.length){
            List<Integer> newList = new ArrayList<>();
            for (Integer integer : ans ) {
                newList.add(integer);
            }
            res.add(newList);
        }

        for (int i = 0; i < nums.length; i++) {
            //剪枝情况
            if(visited[i])continue;
            //这个判断需要理解
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            
            visited[i] = true;
            ans.add(nums[i]);
            backtrack2(nums,ans, visited);
            visited[i] = false;
            ans.remove(ans.size()-1);
        }
    }
    

    public static void main(String[] args) {
        int []nums = {1,1,2};
        PermuteUnique permuteUnique =new PermuteUnique();
        permuteUnique.permuteUnique(nums);    

    }
}