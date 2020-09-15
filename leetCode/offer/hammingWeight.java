package leetCode.offer;

public class hammingWeight {
    // you need to treat n as an unsigned value
    public int HammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n = (n - 1) & n;
            cnt++;
        }
        return cnt;
    }
}