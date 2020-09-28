package leetCode.offer;

import java.util.ArrayList;
import java.util.List;

public class findContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int l = 1;
        int sum = 0;
        for (int r = 1; r < target; r++) {
            if (sum < target) {
                sum += r;
            }

            while (sum >= target) {
                if (sum == target) {
                    int[] t = new int[r - l + 1];
                    for (int i = l; i <= r; i++) {
                        t[i - l] = i;
                    }
                    ans.add(t);
                }
                sum -= l;
                l++;
            }
        }
        int n = ans.size();
        int[][] temp = new int[n][];
        for (int i = 0; i < n; i++) {
            temp[i] = ans.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        findContinuousSequence f = new findContinuousSequence();
        System.out.println(f.findContinuousSequence(9));
    }
}