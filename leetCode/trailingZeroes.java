package leetCode;

/**
 * trailingZeroes
 */
public class trailingZeroes {
    public int TrailingZeroes(int n) {
        int zeroCount = 0;
        //有多少个 5 ，多少个 25，多少个125
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}