package leetCode;

public class maximumProduct {
    public int MaximumProduct(int[] nums) {
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x >= m1) {
                m3 = m2;
                m2 = m1;
                m1 = x;
            } else if (x >= m2) {
                m3 = m2;
                m2 = x;
            } else if (x >= m3) {
                m3 = x;
            }

            if (x <= min1) {
                min2 = min1;
                min1 = x;
            } else if (x <= min2) {
                min2 = x;
            }
        }
        return Math.max(min1 * min2 * m1, m1 * m2 * m3);
    }

    public static void main(String[] args) {
        maximumProduct m = new maximumProduct();
        int[] nums = { -1, -2, -3 };
        System.out.println(m.MaximumProduct(nums));
    }
}