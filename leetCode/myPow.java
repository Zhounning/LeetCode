package leetCode;
/**
 * MyPow
 * 202-07-11 重做
 */
public class myPow {
    //使用快幂算法
    public double MyPow(double x, int n) {
        long N = n;
        return N >= 0 ? fastpow(x, N) : 1.0 / fastpow(x, -N);
    }

    public double fastpow( double x,long n){
        double ans = 1.0;
        //贡献值
        // 贡献的初始值为 x
        double x_contribute = x;

        while(n>0){
            if (n%2!=0) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            n /= 2;
        }
        return ans;
    }
}