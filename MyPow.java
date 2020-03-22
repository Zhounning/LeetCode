/**
 * MyPow
 */
public class MyPow {
// 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

// 示例 1:

// 输入: 2.00000, 10
// 输出: 1024.00000
// 示例 2:

// 输入: 2.10000, 3
// 输出: 9.26100
// 示例 3:

// 输入: 2.00000, -2
// 输出: 0.25000
// 解释: 2-2 = 1/22 = 1/4 = 0.25
// 说明:

// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/powx-n
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    public double myPow(double x, int n) {
        
        double res = 1.;
        int count = Math.abs(n);
        for(int i=0;i<count;i++){
            if(n>0)
                res = res*x;
            else
                res = res/x;
        }
        return res;
    }

    public double mypow2(double x,int n){
        
        return fastpow(x, n);
    }

    //使用long是因为 -2147483648这个测试用例所以只能这样
    public double fastpow( double x,long n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
        //这一步挺巧妙的，将负号瞬间转化为正的
        if(n<0)
            return 1.0/fastpow(x, -n);   
        
        double half = fastpow(x, n / 2);
        if(n%2==0){
            return half*half;
        }

        return half*half*x;
    }
}