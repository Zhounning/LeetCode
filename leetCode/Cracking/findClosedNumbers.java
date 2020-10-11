package leetCode.Cracking;

import java.util.Arrays;

public class findClosedNumbers {

    public int[] findClosedNumbers(int num) {
        int[] n = new int[32];
        int i = 31;
        while (num > 0) {
            n[i--] = num & 1;
            num >>= 1;
        }
        int []ans = new int[2];
        Arrays.fill(ans, -1);
        
    }
}