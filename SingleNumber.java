
import java.util.HashSet;
import java.util.Iterator;

/**
 * SingleNumber
 */
public class SingleNumber {

    // 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

    // 说明：

    // 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/single-number
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int singleNumber(int[] nums) {
        //HashMap<Integer,Integer> numMap = new HashMap<>();
        HashSet<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])){
                numSet.remove(nums[i]);                
            }else{
                numSet.add(nums[i]);
            }
        }
        Iterator<Integer> it = numSet.iterator();
        return it.next();
    }

    public int singleNumber2(int[] nums){
        int ret = 0;
        for (int index = 0; index < nums.length; index++) {
            int element = nums[index];
            ret = ret ^ element;
        }
        return ret;
    }

}