
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSum
 */
public class ThreeSum {
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
    public List<List<Integer>> threeSum(int[] nums) {
        //究极暴力法，发现解决不了重复，并且也不提倡
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        res.add(ans);
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums){
        //利用双指针，将其转化成两数之和
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        //会产生很多重复，需要想办法
        int p1 =0;
        int p2 =nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            p1=i+1;p2 = nums.length-1;
            while (p1<p2) {
                
                if (p1==i) {
                    p1++;
                    
                }else if(p2==i){
                    p2--;
                   
                }else if(nums[p1]+nums[p2]==target){
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[p1]);
                    ans.add(nums[p2]);
                    ans.add(target);
                    res.add(ans);
                    while(nums[p1]==nums[p1+1]){
                        p1++;
                    }

                    while (nums[p2]==nums[p2--]) {
                        p2--;
                    }
                    
                }else if(nums[p1]+nums[p2]<target){
                    p1++;
                }else if(nums[p1]+nums[p2]>target){
                    p2--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }

}