package leetCode;
/**
 * RemoveDuplicates
 */
public class RemoveDuplicates {
    // 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    // 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //说白了统计不相同字的个数,直接使用双指针
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int res = 1;
        int last = 0;   //记录上个数字的位置
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(temp!=nums[i]){
                nums[last+1] = nums[i];
                res++;
                last++;
                temp =nums[i];
            }

        }
        return res;
    }

    // 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

    // 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    
    // 示例 1:
    
    // 给定 nums = [1,1,1,2,2,3],
    
    // 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
    
    // 你不需要考虑数组中超出新长度后面的元素。
    // 示例 2:
    
    // 给定 nums = [0,0,1,1,1,1,2,3,3],
    
    // 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
    
    // 你不需要考虑数组中超出新长度后面的元素。
    // 说明:
    
    // 为什么返回数值是整数，但输出的答案是数组呢?
    
    // 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
    
    // 你可以想象内部操作如下:
    
    // // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
    // int len = removeDuplicates(nums);
    
    // // 在函数里修改输入数组对于调用者是可见的。
    // // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
    // for (int i = 0; i < len; i++) {
    //     print(nums[i]);
    // }
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public int removeDuplicates2(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
            if(nums==null||nums.length==0)
            return 0;

        int length = 1; //最终数组的长度
        int lastposition = 0;   //上次的位置
        int allowLength = 1;    //容忍的长度

        for (int i = 1; i < nums.length; i++) {
            
            if (nums[lastposition]==nums[i]) {
                //当出现重复数字的时候
                if (allowLength<=1) {
                    allowLength++;
                    nums[++lastposition]=nums[i];
                    length++;
                }
                
            }else{
                //说明不相同
                nums[++lastposition] = nums[i];
                length++;
                allowLength = 1;
            }
        }

        return length;
        
    }
}