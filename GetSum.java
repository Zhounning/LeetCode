/**
 * GetSum
 */
public class GetSum {
    // 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。

    // 示例 1:
    
    // 输入: a = 1, b = 2
    // 输出: 3
    
    // 来源：力扣（LeetCode）
    // 链接：https://leetcode-cn.com/problems/sum-of-two-integers
    // 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //很显然使用位运算符
    public int getSum(int a, int b) {
        //异或表示无进位的加法
        //与表示进位运算
        return getSum(a^b, a&b);
    }
}