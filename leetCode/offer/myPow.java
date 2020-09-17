package leetCode.offer;

public class myPow {
    public double MyPow(double x, int n) {
        long N = n;
        return n > 0 ? fastPow(x, N) : 1 / (fastPow(x, -N));
    }

    double fastPow(double x, long n) {
        double ans = 1.0;
        double x_contribute = x; // 贡献值
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x_contribute;
            }
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        double x = -0.1;
        System.out.println(x * 10);
    }
}