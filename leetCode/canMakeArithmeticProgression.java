package leetCode;

import java.util.Arrays;

public class canMakeArithmeticProgression {
    public boolean CanMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        if (arr.length > 2) {
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] != d) {
                    return false;
                }
            }
        }
        return true;
    }
}