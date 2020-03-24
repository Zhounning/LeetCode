import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSException;

/**
 * GetPermutation
 */
public class GetPermutation {
    // 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

    // 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
    
    // "123"
    // "132"
    // "213"
    // "231"
    // "312"
    // "321"
    // 给定 n 和 k，返回第 k 个排列。
    
    // 说明：
    
    // 给定 n 的范围是 [1, 9]。
    // 给定 k 的范围是[1,  n!]。
    // 示例 1:
    
    // 输入: n = 3, k = 3
    // 输出: "213"
    // 示例 2:
    
    // 输入: n = 4, k = 9
    // 输出: "2314"
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/permutation-sequence
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public static String getPermutation(int n, int k) {

        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(i+1);
        }
        return backtrack(nums, k-1);
    }


    /**
     * 
     * @param nums
     * @param k 从nums数组排列中找第几个数
     * @return
     */
    public static String backtrack(List<Integer>nums,int k){
        int length = nums.size();
        if(length==1)
            return String.valueOf(nums.get(0));
        
        
        int div = 1;
        for (int i = 1; i <length; i++) {
            div = div * i;
        }

        
        int choice = k/div;
        String a = String.valueOf(nums.get(choice));
        nums.remove(choice);
        
        return a+backtrack(nums, k%div);
    }

    public static void main(String[] args) {
        getPermutation(3,3);
    }
}