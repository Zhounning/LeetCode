package leetCode.offer;

public class numWays {
    public int NumWays(int n) {
        if (n==0) {
            return 1;
        }
        long a = 1;
        long b = 1;
        long c = 1;
        int MOD_NUM = 1000000007;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % MOD_NUM;
            a = b % MOD_NUM;
            b = c % MOD_NUM;
        }
        return (int) c;
    }
}