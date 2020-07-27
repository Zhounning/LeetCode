package leetCode;

public class twoSum2 {
    // 双指针
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        int p1 = 0;
        int p2 = numbers.length - 1;
        while (p1 < p2) {
            if (numbers[p1] + numbers[p2] == target) {
                return new int[] { p1 + 1, p2 + 1 };

            } else if (numbers[p1] + numbers[p2] < target) {
                ++p1;
            } else {
                --p2;
            }
        }

        return null;
    }
}