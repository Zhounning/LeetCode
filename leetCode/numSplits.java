package leetCode;

import java.util.HashSet;

public class numSplits {

    public int numSplits(String s) {
        int n = s.length();
        // 一个正着统计，一个反者统计
        int[] p = new int[n];
        int[] q = new int[n];
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (int i = 0; i < n; i++) {

            if (!set1.contains(s.charAt(i))) {
                p[i] = i == 0 ? 1 : p[i - 1] + 1;
                set1.add(s.charAt(i));
            } else {
                p[i] = p[i - 1];
            }

            int j = n - i - 1;
            if (!set2.contains(s.charAt(j))) {
                q[j] = j == n - 1 ? 1 : q[j + 1] + 1;
                set2.add(s.charAt(j));
            } else {
                q[j] = q[j + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (p[i] == q[i + 1]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        numSplits n = new numSplits();
        String s = "acbadbaada";
        System.out.println(n.numSplits(s));
    }
}