package leetCode;
/**
 * Search
 */
public class search {
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