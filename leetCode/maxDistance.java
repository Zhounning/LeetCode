package leetCode;

import java.util.Arrays;

/**
 * maxDistance
 */
public class maxDistance {

    public int MaxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int minLen = Integer.MAX_VALUE;
        int maxLen = position[n - 1] - position[0];
        for (int i = 0; i < n - 1; i++) {
            if (minLen > position[i + 1] - position[i]) {
                minLen = position[i + 1] - position[i];
            }
        }
        if (m == 2) {
            return maxLen;
        }
        int mid = 0;
        int left = minLen;
        int right = maxLen / (m - 1);
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (check(mid, position, m)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    boolean check(int x, int[] position, int m) {
        int cnt = 0;
        int target = position[0] + x;
        for (int i = 0; i < position.length - 1; i++) {
            // 说明 i到i+1之间的距离满足要求
            if (position[i] < target && position[i + 1] >= target) {
                cnt++;
                target = position[i + 1] + x;
            }
        }
        // 是不是大于m-1段
        return cnt >= m - 1;
    }

    public static void main(String[] args) {
        int[] position = { 1,2,3,4,7};
        int m = 3;
        maxDistance ma = new maxDistance();
        System.out.println(ma.MaxDistance(position, m));
    }
}