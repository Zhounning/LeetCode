package leetCode;
/**
 * Divide
 * 2020-07-06重写
 */
public class divide {
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

    //二分法
    public int Divide(int dividend, int divisor) {
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE; // 溢出
        int ans = 0;
        //不转化为 long的话-2147483648会被当作0
        long up = Math.abs((long)dividend),down = Math.abs((long)divisor);
        while (up>=down) {
            int count =1;
            long base = down;
            while (up>(base<<1)) {
                count<<=1;
                base<<=1;
            }
            ans+=count;
            up-=base;
        }
        ans = ((dividend < 0)^(divisor < 0)) ? -ans : ans;
        return ans;
    }



    public static void main(String[] args) {
        divide d = new divide();
        int dividend=-2147483648; 
        int divisor=1;
        System.out.println(d.Divide(dividend, divisor));
    }
}