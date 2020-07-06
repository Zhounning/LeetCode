package leetCode;

public class searchInsert {
    public int SearchInsert(int[] nums, int target) {
        if (nums==null||nums.length==0) {
            return -1;
        }

        int left = 0,right = nums.length-1,mid = 0;
        while (left<=right) {
            mid = (left+right)/2;
            if (nums[mid]==target) {
                return mid;
            }else if(nums[mid]<target){
                left=mid+1;

            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        searchInsert s =new searchInsert();
        int []nums={1,3,5,6};
        int target = 0;
        System.out.println(s.SearchInsert(nums, target));
    }
}