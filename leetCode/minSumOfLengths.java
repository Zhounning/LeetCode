package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * minSumOfLengths
 */
public class minSumOfLengths {

    public int MinSumOfLengths(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        Integer sum = 0;
        int res = Integer.MAX_VALUE;
        // 记录下以i结尾的最短子数组
        List<Integer> m_f = new ArrayList<>();
        int mi = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
            if (map.containsKey(sum - target)) {
                int l_i = map.get(sum - target);
                int ttt = i - l_i;
                if (mi == 0) {
                    mi = ttt;
                } else {
                    mi = Math.min(mi, ttt);
                }
                m_f.add(mi);
                if (l_i != -1 && m_f.get(l_i) != 0)
                    res = Math.min(res, m_f.get(l_i) + ttt);
            } else {
                m_f.add(mi);
            }
        }
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        minSumOfLengths m = new minSumOfLengths();
        int[] arr = { 4, 1, 1, 2, 2 };
        int target = 4;
        System.out.println(m.MinSumOfLengths(arr, target));
    }
}
