package leetCode;

import java.util.Arrays;

/***
 * 完全平方数 和 找零钱是一个道理
 */
public class numSquares {
    public int NumSquares(int n) {
        // dp[i]表示 数 i 需要的组成和的完全平方数的个数最小值
        int[] dp = new int[n + 1];
        //填入5，
        //因为 四平方定理： 任何一个正整数都可以表示成不超过四个整数的平方之和，说明最多为4
        Arrays.fill(dp, 5);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            
            for (int j = 1; j*j <=i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}