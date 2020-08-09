package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class strStr {
    public int StrStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0)
            return 0;
        if (haystack == null || haystack.length() < needle.length())
            return -1;
        return sunday(haystack, needle);
    }

    public int KMP(String ts, String ps) {

        char[] t = ts.toCharArray();

        char[] p = ps.toCharArray();

        int i = 0; // 主串的位置

        int j = 0; // 模式串的位置

        int[] next = getNext(ps);

        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }

    public int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }

            } else {
                k = next[k];
            }
        }
        return next;
    }

    public int sunday(String ts, String ps) {
        char[] tarray = ts.toCharArray();
        char[] parray = ps.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < parray.length; i++) {
            charMap.put(parray[i], i);
        }

        int slen = ts.length();
        int plen = ps.length();
        int i = 0, j = 0;
        while (i < slen) {// 这句话控制索引i,j的范围
            if (tarray[i] != parray[j]) {// 假如主串的sarry[i]与模式串的parray[j]不相等
                if (i >= slen - plen + j) {//
                    return -1;// 假如主串的sarry[i]与模式串的parray[j]不相等,并且i=slen-plen+j,说明这已经
                    // 是在和主串中最后可能相等的字符段比较了,并且不相等,说明后面就再也没有相等的了,所以
                    // 跳出循环,结束匹配
                }
                // 假如是主串的中间字段与模式串匹配，且结果不匹配
                // 则就从模式串的最后面开始,(注意是从后向前)向前遍历,找出模式串的后一位在对应的母串的字符是否在子串中存在
                int pos = charMap.getOrDefault(tarray[i + plen - j], -1);
                if (pos == -1) {// 表示不存在
                    i = i + plen + 1 - j;
                    j = 0;
                } else {
                    i = i + plen - pos - j;
                    j = 0;
                }
            } else {// 假如主串的sarry[i]与模式串的parray[j]相等,则继续下面的操作
                if (j == plen - 1) {// 判断模式串的索引j是不是已经到达模式串的最后位置，
                    // j==plen-1证明在主串中已经找到一个模式串的位置,
                    // 且目前主串尾部的索引为i,主串首部的索引为i-j,打印模式串匹配的第一个位置
                    return i - j;
                } else {
                    // 假如模式串的索引j!=plen-1,说明模式串还没有匹配完,则i++,j++继续匹配,
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        strStr s = new strStr();
        // System.out.println(Arrays.toString(s.getNext(ps)));
        String haystack = "mississippi";
        String needle = "sippia";
        System.out.println(s.StrStr(haystack, needle));

    }
}