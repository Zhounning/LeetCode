package leetCode.offer;

public class missingNumber {
    public int MissingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (mid == nums[mid]) {
                // 说明在右半
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] == left) {
            return left + 1;
        }
        return left;
    }

    public static void main(String[] args) {

    }
}