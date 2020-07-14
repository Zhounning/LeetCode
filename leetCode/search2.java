package leetCode;

public class search2 {
    public boolean search(int[] nums, int target) {
        if (nums==null||nums.length==0) {
            return false;
        }
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        //使用二分法解决
        while (left<=right) {
            mid = (left+right)/2;
            if(nums[mid]==target)return true;
            
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

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
        return false;
    }

    public static void main(String[] args) {
        search2 s = new search2();
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(s.search(nums, target));
    }
}