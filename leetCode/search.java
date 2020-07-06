package leetCode;
/**
 * Search
 */
public class search {

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
    public int Search(int[] nums, int target) {
        if (nums==null||nums.length==0) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        //使用二分法解决
        while (left<=right) {
            mid = (left+right)/2;
            if(nums[mid]==target)return mid;
            if (nums[left]<=nums[mid]) {
                //说明 从 left到mid都为有序
                if (nums[left]<=target && nums[mid]>target) {
                   //说明 target在left到mid
                   right = mid-1;
                } else {
                    //说明 target在left到mid
                    left = mid+1;
                }
                
            }else{
                //说明 从 mid+1到right为有序
                if (nums[mid+1]<=target && nums[right]>=target) {
                    //说明在 mid+1到right
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search s = new search();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 5;
        System.out.println(s.Search(nums, target));
    }
}