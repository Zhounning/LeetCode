package leetCode;

public class findMin {
    // 这种比较巧妙，寻找到最终选择点
    public int FindMin(int[] nums) {
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
            } else {
                // 说明从 left 到 mid为有序
                left = mid+1;
            }
        }
        return nums[left];
    }

    public int FindMin2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int minNum = Integer.MAX_VALUE;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[left] <= nums[mid]) {
                // 说明从 left 到 mid为有序
                minNum = Math.min(minNum, nums[left]);
                left = mid + 1;
            } else {
                // 说明从 mid 到 right为有序
                minNum = Math.min(minNum, nums[mid]);
                right = mid - 1;
            }
        }
        return minNum;
    }

    public static void main(String[] args) {
        findMin f = new findMin();
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(f.FindMin2(nums));
    }
}