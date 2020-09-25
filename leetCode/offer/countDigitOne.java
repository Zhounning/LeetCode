package leetCode.offer;

import java.util.Arrays;

public class countDigitOne {
    public int CountDigitOne(int n) {
        dp = new int[50][50];
        num = new int[50];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n);
    }

    int solve(int x) {
        int pos = 0;
        while (x != 0) {
            num[pos++] = x % 10;
            x /= 10;
        }
        return dfs(pos - 1, true, 0);
    }

    int[][] dp;
    int[] num;// 控制枚举范围

    int dfs(int pos, boolean limit, int sta) {
        if (pos == -1) {
            return sta;
        }
        if (!limit && dp[pos][sta] != -1)
            return dp[pos][sta];
        int up = limit ? num[pos] : 9;
        int ans = 0, nsta;
        for (int i = 0; i <= up; i++) {
            if (i == 1) {
                nsta = sta + 1;
            } else {
                nsta = sta;
            }
            ans += dfs(pos - 1, limit && (i == num[pos]), nsta);
        }
        if (!limit) {
            dp[pos][sta] = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        countDigitOne c = new countDigitOne();
        int n = 21;
        System.out.println(c.CountDigitOne(n));
    }
}