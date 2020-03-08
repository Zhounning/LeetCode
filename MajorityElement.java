/**
 * MajorityElement
 */
public class MajorityElement {
//     给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

//     你可以假设数组是非空的，并且给定的数组总是存在多数元素。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/majority-element
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int majorityElement(int[] nums) {
        //类似于找水王，找元素最多的数
        //采取投票法，比较简单
        
        int res = nums[0];
        int count = 0;  //出现的次数
        for (int i = 0; i < nums.length; i++) {
            
            if(res==nums[i]){
                count++;
            }else{

                if(count==0){
                    res = nums[i];
                    count++;
                }else{
                    count--;
                }
                    
            }
        }
        return res;
    }
}