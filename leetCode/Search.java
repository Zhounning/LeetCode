package leetCode;
/**
 * Search
 */
public class Search {

    // 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

    // ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
    
    // 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
    
    // 你可以假设数组中不存在重复的元素。
    
    // 你的算法时间复杂度必须是 O(log n) 级别。
    
    // 示例 1:
    
    // 输入: nums = [4,5,6,7,0,1,2], target = 0
    // 输出: 4
    // 示例 2:
    
    // 输入: nums = [4,5,6,7,0,1,2], target = 3
    // 输出: -1
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public int search(int[] nums, int target) {
        if (nums==null||nums.length==0) {
            return -1;
        }

        //先用双指针找到旋转的位置
        int left = 0;
        int right = nums.length-1;
        // int mid = (left+right)/2;

        while (left<=right) {
            int mid = (left+right)/2;
            if(nums[mid]==target) return mid;

            if (nums[mid]<=nums[right]) {
                //说明 mid 的位置在 右边的有序部分，则从 mid 到 right都是有序的，是升序

                if (nums[mid]<=target && nums[right]>=target) {
                    // 说明target在这一部分
                    left = mid+1;       
                    
                }else{
                    //说明target在另外一边
                    right = mid-1;   
                }


            }else{
                //同理说明从 left 到 mid是有序的，且两部分都是升序

                if (nums[left]<=target && nums[mid]>=target) {
                    // 说明target在这一部分
                    right = mid-1;
                }else{
                    left = mid+1;
                }

            }
        }
      
        return -1;
    }
}