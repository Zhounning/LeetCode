package leetCode;

public class findMin2 {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                // 说明从 mid+1 到 right为有序
                right = mid;
            } else if(nums[mid]>nums[right]){
                // 说明从 left 到 mid为有序
                left = mid+1;
            }else{
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        findMin2 f = new findMin2();
        int[] nums = {2,2,2,0,1 };
        System.out.println(f.findMin(nums));
    }
}