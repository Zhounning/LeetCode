package leetCode;
/**
 * HammingWeight
 */
public class HammingWeight {
    // 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
         //和1进行&操作
         //记录一下n&(n-1)比较巧妙
         int res = 0;
         for (int i = 0; i < 32; i++) {
             if ((n&1)==1) {
                 res++;
             }
             n=n>>1;
         }
         return res;
    }
}