package leetCode;

public class findPeakElement {
    public int FindPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 当 nums[mid] > nums[mid+1]时，说明 从 mid 到 mid+1是一段下坡，则在 left->mid肯定有一个波峰
                right = mid;
            } else {
                // 同上，当 nums[mid] <nums[mid+1] 时，说明 从 mid到mid+1是一段上坡，则在mid+1->right重肯定有个波峰
                left = mid + 1;
            }
        }
        return left;
    }
}