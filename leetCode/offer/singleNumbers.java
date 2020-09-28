package leetCode.offer;

import java.util.ArrayList;

/**
 * singleNumbers
 */
public class singleNumbers {

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum = sum ^ i;
        }
        int mask = 1;
        int count = 0;
        while ((sum & 1) != 1) {
            sum = sum >> 1;
            mask = mask << 1;
            count++;
        }

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i : nums) {
            if (((i & mask) >> count) == 1) {
                a.add(i);
            } else {
                b.add(i);
            }
        }
        int[] ans = new int[2];
        for (int i : a) {
            ans[0] = ans[0] ^ i;
        }

        for (int i : b) {
            ans[1] = ans[1] ^ i;
        }
        return ans;
    }

    public static void main(String[] args) {
        singleNumbers s = new singleNumbers();
        int[] nums = { 1, 2, 10, 4, 1, 4, 3, 3 };
        System.out.println(s.singleNumbers(nums));
    }
}