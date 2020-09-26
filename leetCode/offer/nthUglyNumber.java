package leetCode.offer;

public class nthUglyNumber {
    public int NthUglyNumber(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int tmp = Math.min(dp[p5] * 5, Math.min(dp[p2] * 2, dp[p3] * 3));
            if (tmp == dp[p2] * 2) {
                p2++;
            }
            if (tmp == dp[p3] * 3) {
                p3++;
            }
            if (tmp == dp[p5] * 5) {
                p5++;
            }
            dp[i] = tmp;
        }
        return dp[n-1];
    }
}