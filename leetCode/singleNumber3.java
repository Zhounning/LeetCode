package leetCode;

/**
 * singleNumber3
 */
public class singleNumber3 {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor = xor ^ i;
        }
        int mask = 1;
        while ((xor & 1) == 0) {
            xor >>= 1;
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if ((mask & i) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[] { a, b };
    }
}
