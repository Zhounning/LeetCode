/**
 * RemoveDuplicates
 */
public class RemoveDuplicates {
    // 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

    // 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //说白了统计不相同字的个数
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
}