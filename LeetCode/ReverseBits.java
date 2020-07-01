package leetCode;
/**
 * ReverseBits
 */
public class ReverseBits {

    // 颠倒给定的 32 位无符号整数的二进制位。
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        //和1进行&操作
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res<<1)+(1&n);
            n=n>>1;
        }
        return res;
    }
 
}