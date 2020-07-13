package leetCode;

public class mySqrt {
    public int MySqrt(int x) {
        int n = 1;
        //防止溢出,使用 x/n>=n 也可以 ,但是似乎x>=(long)n*n更快
        while (x>=(long)n*n) {
            n++;
        }
        return n-1;
    }

    public int MySqrt2(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

    //牛顿法
    public int MySqrt3(int x){
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }

    public static void main(String[] args) {
        mySqrt m = new mySqrt();
        System.out.println(m.MySqrt(10001));
    }
}