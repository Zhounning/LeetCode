package leetCode;

import java.util.HashMap;

public class canConvertString {
    public boolean CanConvertString(String s, String t, int k) {
        // 长度首先相等
        if (s.length() != t.length()) {
            return false;
        }
        int n = s.length();
        // 统计差值次数
        HashMap<Integer, Integer> counts = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int a = s.charAt(i) - 'a';
            int b = t.charAt(i) - 'a';
            if (a - b != 0) {
                int count = 0;
                if (b - a > 0) {
                    count = b - a;
                } else {
                    count = 26 + b - a;
                }

                if (counts.containsKey(count)) {
                    // 说明这个次数用过了
                    counts.put(count, counts.get(count) + 1);
                    count = (counts.get(count) - 1) * 26 + count;
                } else {
                    counts.put(count, 1);
                }
                res = Math.max(res, count);
            }

        }

        return res <= k;
    }

    public static void main(String[] args) {
        canConvertString c = new canConvertString();
        String s = "atmtxzjkz", t = "tvbtjhvjd";
        int k = 35;
        System.out.println(c.CanConvertString(s, t, k));
    }
}