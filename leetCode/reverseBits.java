package leetCode;

public class reverseBits {

    // you need treat n as an unsigned value
    public int ReverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (1 & n);
            n = n >> 1;
        }
        return res;
    }
}