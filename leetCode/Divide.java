package leetCode;
/**
 * Divide
 */
public class Divide {
    // 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

    // 返回被除数 dividend 除以除数 divisor 得到的商。
    
    // 示例 1:
    
    // 输入: dividend = 10, divisor = 3
    // 输出: 3
    // 示例 2:
    
    // 输入: dividend = 7, divisor = -3
    // 输出: -2
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/divide-two-integers
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    // 说明:

    // 被除数和除数均为 32 位有符号整数。
    // 除数不为 0。
    // 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/divide-two-integers
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    //这样写最终超时
    int divide(int dividend, int divisor) {
        int res = 0;
        boolean isPositive = false;
        

        if (dividend==Integer.MIN_VALUE&&divisor==-1) {
            return Integer.MAX_VALUE;
        }

        if (dividend==Integer.MIN_VALUE&&divisor==1) {
            return Integer.MIN_VALUE;
        }

        if((dividend>0&&divisor>0) || (dividend<0&&divisor<0))
            isPositive = true;
        else
            isPositive = false;


        //全部转化为正的处理
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if(dividend<divisor||dividend==0)
            return 0;
        
        if(divisor==1)
            return isPositive?dividend:-dividend;
        
        int temp = divisor;
        while (dividend>=divisor) {
            divisor+=temp;
            res++;
        }
        return isPositive?res:-res;
    }
    


    int divide2(int dividend, int divisor){
        if(divisor == 1) return dividend;
        if (divisor==-1) {
            if(dividend == Integer.MIN_VALUE)
                return Integer.MAX_VALUE;
            return dividend*-1;
        }
        long count = 0;
        boolean isPositive = false;

        if((dividend>0&&divisor>0) || (dividend<0&&divisor<0))
            isPositive = true;
        else
            isPositive = false;
        long a = dividend;
        long b = divisor;
        a = a>0?a:-a;
        b = b>0?b:-b;
        count = helper(a,b);
        if (count > Integer.MAX_VALUE  || count < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE-1;
        }
        return isPositive?(int)count : -1*(int)count;
    }

    int helper(long dividend, long divisor){
         // 二分法
         if (dividend <= 0) return 0;
         if (dividend < divisor) return 0;
         if (divisor == 1) return (int)dividend;
 
         long acc = divisor*2;
         int count = 1;
 
         while(dividend>acc){
             acc+=acc;
             count+=count;
         }
 
         long last = dividend - (acc/2);
         return count+helper(last, divisor);
    }



    public static void main(String[] args) {
        Divide divide = new Divide();
        int dividend=-2147483648; 
        int divisor=2;
        System.out.println(divide.divide2(dividend, divisor));
    }
}