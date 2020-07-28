package leetCode;

public class hammingWeight {
    public int HammingWeight(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }

    public int HammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}