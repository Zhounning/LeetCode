package leetCode;
import java.util.ArrayList;
import java.util.List;

/**
 * Permute
 */
public class Permute {

    // 给定一个没有重复数字的序列，返回其所有可能的全排列。

    // 示例:
    
    // 输入: [1,2,3]
    // 输出:
    // [
    //   [1,2,3],
    //   [1,3,2],
    //   [2,1,3],
    //   [2,3,1],
    //   [3,1,2],
    //   [3,2,1]
    // ]
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/permutations
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ans =new ArrayList<>();
        backtrack(nums, ans, 0);
        return res;
    }

    public void backtrack(int [] nums,List<Integer>ans,int n){
        if(n==nums.length) {
            List<Integer> newList = new ArrayList<>();
            for (Integer integer : ans ) {
                newList.add(integer);
            }
            
            res.add(newList);
           
        }

        for (int i = n; i < nums.length; i++) {
            //进行交换
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;

            ans.add(nums[n]);
            backtrack(nums, ans, n+1);
            ans.remove(ans.size()-1);
            nums[n] = nums[i];
            nums[i] = temp;
        }
       
    }

    public void backtrack2(int [] nums,List<Integer>ans,int n){
        if(n==nums.length) {
            List<Integer> newList = new ArrayList<>();
            for (Integer integer : ans ) {
                newList.add(integer);
            }
            
            res.add(newList);
           
        }

        for (int i = n; i < nums.length; i++) {
            //进行交换
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;

            ans.add(nums[n]);
            backtrack(nums, ans, n+1);
            ans.remove(ans.size()-1);
            nums[n] = nums[i];
            nums[i] = temp;
        }
        
    }

    public static void main(String[] args) {
        int []nums = {1,2,3};
        Permute permute =new Permute();
        permute.permute(nums);    
    }
}