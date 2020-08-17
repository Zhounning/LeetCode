package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import sun.applet.Main;

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

    Map<Integer, Integer> map = new HashMap<>();

    // 高级方法
    public int MinDays2(int n) {
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = Math.min(MinDays2(n/3)+n%3+1, MinDays2(n/2)+n%2+1);
        map.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        minDays m = new minDays();
        int n = 16;
        System.out.println(m.MinDays2(n));
    }
}