package leetCode;

import java.util.ArrayList;
import java.util.List;

public class findAnagrams {
    public List<Integer> FindAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        // 申请一个散列，用于记录窗口中具体元素的个数情况
        // 这里用数组的形式呈现，也可以考虑其他数据结构
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        int[] hash = new int[26];

        for (int i = 0; i < pArr.length; ++i) {
            hash[pArr[i] - 'a']++;
        }

        // l 表示左指针
        // count 记录当前的条件，具体根据题目要求来定义
        // result 用来存放结果
        List<Integer> results = new ArrayList<>();
        int l = 0, count = 0, pLength = p.length();
        for (int r = 0; r < sArr.length; ++r) {
            // 更新新元素在散列中的数量
            hash[sArr[r] - 'a']--;

            // 根据窗口的变更结果来改变条件值
            if (hash[sArr[r] - 'a'] >= 0) {
                count++;
            }

            // 如果当前条件不满足，移动左指针直至条件满足为止
            if (r > pLength - 1) {
                // 再这里是到了最右端
                hash[sArr[l] - 'a']++;
                if (hash[sArr[l] - 'a'] > 0) {
                    count--;
                }
                l++;
            }

            // 更新结果
            if (count == pLength) {
                results.add(l);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String s = "acbab";
        String p = "cb";
        findAnagrams f = new findAnagrams();
        System.out.println(f.FindAnagrams(s, p));
    }
}