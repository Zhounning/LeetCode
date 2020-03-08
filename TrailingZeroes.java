/**
 * TrailingZeroes
 */
public class TrailingZeroes {
    // 给定一个整数 n，返回 n! 结果尾数中零的数量。

    public int trailingZeroes(int n) {
        //0是由5和2相乘得来，所以只要找出有多少个5就行（2远远多于5的个数）
        //最后转化为了类似于5进制的问题

        int res=0;
        while (n!=0) {
            n=n/5;
            res+=n;
        }
        return res;
    }
}