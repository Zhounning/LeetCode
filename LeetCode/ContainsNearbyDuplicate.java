import java.util.HashMap;

/**
 * ContainsNearbyDuplicate
 */
public class ContainsNearbyDuplicate {

    // 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        if (nums==null||nums.length==0) {
            return false;
        }

        HashMap<Integer,Integer> numsMap = new HashMap<>();
        boolean res = false;
        for (int i = 0; i < nums.length; i++) {
            
            if (numsMap.containsKey(nums[i])) {
                int last = numsMap.get(nums[i]);
                if (i-last>k) {
                    return false;
                }
                res = true;
            }
            numsMap.put(nums[i], i);
        }

        return res;
    }

    public static void main(String[] args) {
        int [] a= new int[0];
        System.out.println(a.length);
    }
}