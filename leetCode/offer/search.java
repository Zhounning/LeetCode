package leetCode.offer;

public class search {
    public int Search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] != target) {
            return 0;
        }
        int i = left;
        while (i >= 0 && nums[i] == target) {
            i--;
        }
        int j = left;
        while (j < nums.length && nums[j] == target) {
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        search s = new search();
        System.out.println(s.Search(nums, target));
    }
}