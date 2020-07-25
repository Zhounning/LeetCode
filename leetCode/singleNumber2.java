package leetCode;

public class singleNumber2 {
    int seenOnce = 0, seenTwice = 0;
    public int singleNumber(int[] nums) {
        for (int num : nums) {
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        return seenOnce;
    }
}