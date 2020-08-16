package leetCode;

import java.util.Arrays;

public class minDays {
    // 创建数组
    public int MinDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[n];
    }

    // 滚动数组
    public int MinDays2(int n) {
        int res = 0;
        while (n > 0) {
            if ((n & (n - 1)) != 0 && (n - 1) % 3 == 0) {
                n = n - 1;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n - 1;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        minDays m = new minDays();
        int n = 16;
        System.out.println(m.MinDays2(n));
    }
}