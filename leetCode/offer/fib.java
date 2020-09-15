package leetCode.offer;

public class fib {
    public int Fib(int n) {
        if (n <= 1) {
            return n;
        }

        long a = 0;
        long b = 1;
        long c = 0;
        int MOD_NUM = 1000000007;
        for (int i = 2; i <= n; i++) {
            c = (a + b) % MOD_NUM;
            a = b % MOD_NUM;
            b = c % MOD_NUM;
        }
        return (int) c;
    }

    public static void main(String[] args) {
    }
}