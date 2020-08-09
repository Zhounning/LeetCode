
package leetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * findKthPositive
 */
public class findKthPositive {

    public int FindKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer integer : arr) {
            set.add(integer);
        }
        int start = 1;
        for (int i = 0; i < k; i++) {
            while (set.contains(start)) {
                start++;
            }
            set.add(start);
        }
        return start;
    }

    public static void main(String[] args) {
        findKthPositive f = new findKthPositive();
        int[] arr = { 2,3,4,7,11 };
        int k = 5;
        System.out.println(f.FindKthPositive(arr, k));
    }
}